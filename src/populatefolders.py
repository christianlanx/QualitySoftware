import os

# Paths for the main and test directories
main_dir = 'main/java'
test_dir = 'test/java'

# List of models and range of prompt numbers
models = ['ChatGPT4o', 'chatGPTo1Preview', 'ai21Jamba', 'claudeSonnet','copilot']  # Replace with your actual model names
num_prompts = 5  # Adjust this to the number of prompts you need, e.g., 5 for prompt0 to prompt4

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
                readme_path = os.path.join(target_path, 'README.md')
                with open(readme_path, 'w') as readme_file:
                    readme_file.write(f"# {folder_name} - {model} - prompt{prompt_num}\n\nThis is a placeholder README file.")
                
                print(f"Created: {target_path} with README.md")
