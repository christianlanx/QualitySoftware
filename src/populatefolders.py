import os

# Paths for the main and test directories
main_dir = 'main/java'
test_dir = 'test/java'

# List of models and range of prompt numbers
models = ['ChatGPT4o', 'chatGPTo1Preview', 'ai21Jamba', 'claudeSonnet','copilot']  # Replace with your actual model names
num_prompts = 5  # Adjust this to the number of prompts you need, e.g., 5 for prompt0 to prompt4

def delete_readme_files(directory):
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file == 'README.md':
                file_path = os.path.join(root, file)
                os.remove(file_path)
                print(f"Deleted: {file_path}")

# Delete existing README.md files in the test/java directory
delete_readme_files(test_dir)

# Loop through each folder in main/java
for folder_name in os.listdir(main_dir):
    main_folder_path = os.path.join(main_dir, folder_name)

    # Check if it's a directory
    if os.path.isdir(main_folder_path):
        # Create folders for each model and prompt
        for model in models:
            for prompt_num in range(num_prompts):
                target_path = os.path.join(test_dir, folder_name, model, f'prompt{prompt_num}')
                os.makedirs(target_path, exist_ok=True)
                
                java_file_name = f"{folder_name}{model}Test.java"
                java_file_path = os.path.join(target_path, java_file_name)
                with open(java_file_path, 'w') as java_file:
                    java_file.write(f"public class {folder_name}Test {{\n")
                    java_file.write("    // This is a placeholder test class\n")
                    java_file.write("    public void exampleTest() {\n")
                    java_file.write("        // Add test code here\n")
                    java_file.write("    }\n")
                    java_file.write("}\n")
                
                print(f"Created: {java_file_path}")