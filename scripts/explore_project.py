#!/usr/bin/python3
import os
import sys
import yaml
import argparse

def explore_project(root_path):
    project_structure = []

    # Define paths to main classes and test classes
    main_classes_path = os.path.join(root_path, 'src', 'main', 'java')
    test_classes_path = os.path.join(root_path, 'src', 'test', 'java')

    # Function to get classes in a given path
    def get_classes_in_path(base_path):
        classes_by_package = {}
        for root, _, files in os.walk(base_path):
            package = root.replace(base_path, '').replace(os.sep, '.').strip('.')
            classes = [f[:-5] for f in files if f.endswith('.java')]  # Strip '.java' extension
            if classes:
                classes_by_package[package] = classes
        return classes_by_package

    # Get classes in main and test paths
    main_classes = get_classes_in_path(main_classes_path)
    test_classes = get_classes_in_path(test_classes_path)

    # Combine the results into a structured list of dictionaries
    for package, classes in main_classes.items():
        organized_test_classes = {}
        
        # Organize test classes by LLM and prompt
        for test_package, test_class_list in test_classes.items():
            if test_package.startswith(package):
                _, llm, prompt = test_package.split('.')[-3:]
                if llm not in organized_test_classes:
                    organized_test_classes[llm] = {}
                
                organized_test_classes[llm][prompt] = test_class_list[0] if test_class_list else None

        package_info = {
            'package': package,
            'classes': classes,
            'test_classes': organized_test_classes
        }
        project_structure.append(package_info)

    return project_structure

def filter_classes(project_structure, list_option, class_filter=None, llm_filter=None, prompt_filter=None):
    filtered_classes = []

    for package_info in project_structure:
        if list_option == 'list_classes':
            # Filter main classes by class name
            for cls in package_info['classes']:
                if not class_filter or class_filter in cls:
                    filtered_classes.append(f"{package_info['package']}.{cls}")
        
        elif list_option == 'list_test_classes':
            # Filter test classes by class name, llm, and prompt
            for llm, prompts in package_info['test_classes'].items():
                if llm_filter and llm != llm_filter:
                    continue
                for prompt, test_class in prompts.items():
                    if prompt_filter and prompt != prompt_filter:
                        continue
                    if not class_filter or class_filter in test_class:
                        filtered_classes.append(f"{package_info['package']}.{llm}.{prompt}.{test_class}")
    
    return filtered_classes

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Explore project structure")
    parser.add_argument("root_path", help="Root path of the project")
    parser.add_argument("list_option", choices=['list_classes', 'list_test_classes'], 
                        help="Option to list either 'list_classes' or 'list_test_classes'")
    parser.add_argument("--class_filter", help="Filter by class name")
    parser.add_argument("--llm_filter", help="Filter by LLM")
    parser.add_argument("--prompt_filter", help="Filter by prompt")

    args = parser.parse_args()

    # Explore the project structure
    project_structure = explore_project(args.root_path)

    # Filter and display classes based on input parameters
    result = filter_classes(project_structure, args.list_option, args.class_filter, args.llm_filter, args.prompt_filter)
    
    # Output the results in YAML format
    print(yaml.dump(result, sort_keys=False, indent=4))
