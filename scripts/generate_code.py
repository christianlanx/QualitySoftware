import argparse
import os
import re

from project import all_llms, all_prompts, all_packages
from claude import submit_prompt_anthropic
from gpt import submit_prompt_gpt
from jamba import submit_prompt_jamba
from meta import submit_prompt_meta
from mistral import submit_prompt_mistral

def load_prompt_text(package: str, prompt: str) -> str:
    prompt_text_path = os.path.join("prompts", package, f"{prompt}.txt")
    with open(prompt_text_path, 'r') as file:
        prompt_text = file.read()
    return prompt_text

def generate_test_class(prompt: str, prompt_text: str, llm: str) -> str:
    # submit the prompt to the llm and get a response
    match llm:
        case "ai21Jamba15Mini":
            response_text = submit_prompt_jamba(prompt_text, "jamba-1.5-mini")
        case "ai21Jamba15Large":
            response_text = submit_prompt_jamba(prompt_text, "jamba-1.5-large")
        case "claude35Haiku":
            response_text = submit_prompt_anthropic(prompt_text, "claude-3-5-haiku-latest")
        case "claude35Sonnet":
            response_text = submit_prompt_anthropic(prompt_text, "claude-3-5-sonnet-latest")
        case "gpt35Turbo":
            response_text = submit_prompt_gpt(prompt_text, model='gpt-3.5-turbo')
        case "gpt4oMini":
            response_text = submit_prompt_gpt(prompt_text, model='gpt-4o-mini')
        case "gpt4o":
            response_text = submit_prompt_gpt(prompt_text, model='gpt-4o')
        case "gpto1Mini":
            response_text = submit_prompt_gpt(prompt_text, model='o1-mini')
        case "metaAI":
            response_text = submit_prompt_meta(prompt_text)
        case "mistralSmall":
            response_text = submit_prompt_mistral(prompt_text, model='mistral-small-latest')
        case "mistralLarge":
            response_text = submit_prompt_mistral(prompt_text, model='mistral-large-latest')
        case _:
            print("Error, LLM not found")
            return None
    # parse the java code from the response
    start_index = response_text.find("import") # look for the first import statement
    if (start_index == -1):
        print(response_text)
        print("ERROR: unable to find start of java program")
        return None
    end_index = response_text.rfind("}") # look for the last curly brace
    if (end_index == -1):
        print(response_text)
        print("ERROR: unable to find end of java program")
        return None
    generated_test_class = response_text[start_index:end_index+1]
    # prepend the generated test class with a package and import statement
    generated_test_class = f"package {package}.{llm}.{prompt};\nimport {package}.*;\n\n{generated_test_class}"
    return generated_test_class

if __name__ == "__main__":
  
    # Parse command-line arguments
    parser = argparse.ArgumentParser(description="Function to generate Java test classes")
    parser.add_argument("--package", type=str, required=False, default=None, 
                        help="Package for which to generate tests. Default is all packages.")
    parser.add_argument("--prompt", type=str, required=False, default=None, 
                        help="Prompt for which to generate tests. Default is all prompts.")
    parser.add_argument("--llm", type=str, required=False, default=None, choices=all_llms,
                        help="LLM with which to generate tests. Default is all.")
    parser.add_argument("--make_dir", action="store_true",
                        help="Create a directory for the test class if one does not exist.")
    parser.add_argument("--overwrite", action="store_true", 
                        help="Whether to overwrite the existing test class, if one already exists.")
    parser.add_argument("--print", action="store_true", 
                        help="Print output to standard out instead of writing to a file")
    args = parser.parse_args()

    # Handle arguments
    packages = [args.package] if args.package else all_packages
    prompts = [args.prompt] if args.prompt else all_prompts
    llms = [args.llm] if args.llm else all_llms

    # Generate test classes
    for package in packages:
        for llm in llms:
            for prompt in prompts:
                print(f"Generating code for package {package}, using llm {llm} and prompt {prompt}")
                
                # load the requested prompt
                prompt_text = load_prompt_text(package, prompt)

                # Construct test class path
                testclass_path = os.path.join("maven_project", "src", "test", "java", package, llm, prompt)
                
                # Ensure the path exists
                if not os.path.exists(testclass_path):
                    if (args.make_dir):
                        print(f"\tDirectory '{testclass_path}' does not exist. Creating it...")
                        os.makedirs(testclass_path)
                    else:
                        print(f"\tDirectory does not exist. Skipping")
                        continue

                # Check if the directory already contains files
                if (os.listdir(testclass_path) and not args.overwrite):
                    print("\tTest class already exists. Skipping")

                else:
                    if (os.listdir(testclass_path)):
                        print("\tTest class already exists. Overwriting")
                    else:
                        print("\tGenerating test class...")
                    generated_test_class = generate_test_class(prompt, prompt_text, llm)
                    if (args.print):
                        # simply print the test class and exit
                        print(generated_test_class)
                        continue
                    else:
                        match = re.search(r'class (\w+)', generated_test_class)
                        if not match:
                            print(generated_test_class)
                            print("ERROR: test class name not found in test class")
                        testclass_name = match.group(1)
                        output_filename = os.path.join(testclass_path, f"{testclass_name}.java")
                        with open(output_filename, 'w') as file:
                            file.write(generated_test_class)
                        print("\tWrote generated code to ", output_filename)
