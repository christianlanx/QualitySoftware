import os
import sys

def list_classes(directory):
    # List all available classes in the specified directory
    classes = []
    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith(".java"):
                # Get the class name without .java extension
                class_name = os.path.splitext(file)[0]
                classes.append(class_name)
    return classes

def validate_class(class_name, project_dir, test_dir):
    # Check if the specified class exists in the project folder
    found_class = False
    class_file_path = None
    for root, _, files in os.walk(project_dir):
        if f"{class_name}.java" in files:
            found_class = True
            class_file_path = os.path.join(root, f"{class_name}.java")
            break
    
    if not found_class:
        print(f"Error: Class '{class_name}' not found in the project directory.")
        available_classes = list_classes(project_dir)
        if available_classes:
            print("Available classes:")
            for cls in available_classes:
                print(f" - {cls}")
        else:
            print("No classes found in the project directory.")
        sys.exit(1)

    print(f"Class '{class_name}' found at: {class_file_path}")
    
    # Check if there are any test files for the specified class
    test_files = [
        os.path.join(root, file) 
        for root, _, files in os.walk(test_dir) 
        for file in files 
        if file.startswith(class_name) and file.endswith(".java")
    ]
    
    if not test_files:
        print(f"Warning: No test classes found for '{class_name}' in the test directory.")
    else:
        print(f"Test classes found for '{class_name}':")
        for test_file in test_files:
            print(f" - {test_file}")

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python script.py <class_name>")
        sys.exit(1)

    class_name = sys.argv[1]
    project_dir = "./src/main/java"  # Path to your main Java source files
    test_dir = "./src/test/java"     # Path to your test Java source files

    validate_class(class_name, project_dir, test_dir)
