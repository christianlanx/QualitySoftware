import os

# Paths for the main and test directories
main_dir = 'main/java'
test_dir = 'test/java'

# List of models and range of prompt numbers
models = ['chatGPT4o', 'chatGPTo1Preview', 'ai21Jamba', 'claudeSonnet', 'copilot']  # Replace with your actual model names
num_prompts = 5  # Adjust this to the number of prompts you need, e.g., 5 for prompt0 to prompt4

# Loop through each folder in main/java
for folder_name in os.listdir(main_dir):
    main_folder_path = os.path.join(main_dir, folder_name)

    # Check if it's a directory
    if os.path.isdir(main_folder_path):
        # Create folders for each model and prompt
        for model in models:
            for prompt_num in range(num_prompts):
                prompt_name = f'prompt{prompt_num}'
                target_path = os.path.join(test_dir, folder_name, model, prompt_name)
                os.makedirs(target_path, exist_ok=True)
                
                # Create a Java test file named <folder_name><model>Test.java in each folder
                java_file_name = f"{folder_name}{model}Test.java"
                java_file_path = os.path.join(target_path, java_file_name)
                with open(java_file_path, 'w') as java_file:
                    # Write the package statement and class definition
                    java_file.write(f"package {folder_name}.{model}.{prompt_name};\n\n")
                    java_file.write(f"public class {folder_name}{model}Test {{\n")
                    java_file.write("    // This is a placeholder test class\n")
                    java_file.write("    public void exampleTest() {\n")
                    java_file.write("        // Add test code here\n")
                    java_file.write("    }\n")
                    java_file.write("}\n")
                
                print(f"Created: {java_file_path}")
