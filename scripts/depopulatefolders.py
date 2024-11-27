import os

# Paths for the main and test directories
main_dir = 'src/main/java'
test_dir = 'src/test/java'

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
                java_file_name = f"{folder_name}{model}Test.java"
                java_file_path = os.path.join(target_path, java_file_name)
                try:
                    with open(java_file_path, 'r') as f:
                        if 'placeholder' in f.read():
                            os.remove(java_file_path)
                        else:
                            print(f"Skipping {java_file_path}")
                except FileNotFoundError:
                    print(f"File '{java_file_path}' not found.")
