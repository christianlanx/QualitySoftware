import argparse
import os
import re
import logging

from project import all_llms, all_prompts, all_packages
from claude import submit_prompt_anthropic
from gpt import submit_prompt_gpt
from jamba import submit_prompt_jamba
from meta import submit_prompt_meta
from mistral import submit_prompt_mistral

# Constants
TEST_CLASS_BASE_PATH = os.path.join("maven_project", "src", "test", "java")

# Configure logging
logging.basicConfig(
    level=logging.INFO, 
    format='%(asctime)s - %(levelname)s - %(message)s', 
)

def load_prompt_text(package: str, prompt: str) -> str:
    prompt_text_path = os.path.join("prompts", package, f"{prompt}.txt")
    try:
        with open(prompt_text_path, 'r') as file:
            return file.read()
    except FileNotFoundError:
        logging.error(f"Prompt file not found: {prompt_text_path}")
        return None

def generate_test_class(prompt: str, prompt_text: str, llm: str) -> str:
    # Submit the prompt to the LLM and get a response
    response_text = ""
    try:
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
            case "metaAI":
                response_text = submit_prompt_meta(prompt_text)
            case "mistralSmall":
                response_text = submit_prompt_mistral(prompt_text, model='mistral-small-latest')
            case "mistralLarge":
                response_text = submit_prompt_mistral(prompt_text, model='mistral-large-latest')
            case _:
                logging.error(f"Error: LLM '{llm}' not recognized.")
                return None
    except Exception as e:
        logging.error(f"Error during LLM submission: {e}")
        return None

    # Parse the Java code from the response
    start_index = response_text.find("import")
    end_index = response_text.rfind("}")
    if start_index == -1 or end_index == -1:
        logging.error("Failed to parse Java code: Start or end markers not found.")
        return None

    generated_test_class = response_text[start_index:end_index + 1]

    # Add package and imports
    generated_test_class = f"package {package}.{llm}.{prompt};\nimport {package}.*;\n\n{generated_test_class}"
    return generated_test_class

if __name__ == "__main__":
    logging.basicConfig(
        level=logging.INFO, 
        format='%(asctime)s - %(levelname)s - %(message)s', 
    )
    logging.getLogger().setLevel(logging.INFO)

    parser = argparse.ArgumentParser(description="Generate Java test classes")
    parser.add_argument("--package", type=str, default=None, choices=all_packages, help="Package for which to generate tests.")
    parser.add_argument("--prompt", type=str, default=None, choices=all_prompts, help="Prompt for which to generate tests.")
    parser.add_argument("--llm", type=str, default=None, choices=all_llms, help="LLM to use for test generation.")
    parser.add_argument("--make_dir", action="store_true", help="Create missing directories.")
    parser.add_argument("--overwrite", action="store_true", help="Overwrite existing test classes.")
    parser.add_argument("--print", action="store_true", help="Print the generated code instead of saving it.")
    args = parser.parse_args()

    packages = [args.package] if args.package else all_packages
    prompts = [args.prompt] if args.prompt else all_prompts
    llms = [args.llm] if args.llm else all_llms

    for package in packages:
        for llm in llms:
            for prompt in prompts:
                logging.info(f"Generating for package={package}, LLM={llm}, prompt={prompt}")
                prompt_text = load_prompt_text(package, prompt)
                if not prompt_text:
                    continue

                testclass_path = os.path.join(TEST_CLASS_BASE_PATH, package, llm, prompt)
                os.makedirs(testclass_path, exist_ok=True)

                files = os.listdir(testclass_path)
                if files and not args.overwrite:
                    logging.info(f"Skipping: Test class already exists in {testclass_path}")
                    continue

                generated_test_class = generate_test_class(prompt, prompt_text, llm)
                if not generated_test_class:
                    continue

                if args.print:
                    print(generated_test_class)
                else:
                    match = re.search(r'\bclass (\w+)', generated_test_class)
                    if not match:
                        logging.error("Class name not found in the generated code.")
                        continue

                    class_name = match.group(1)
                    output_filename = os.path.join(testclass_path, f"{class_name}.java")
                    with open(output_filename, 'w') as file:
                        file.write(generated_test_class)
                    logging.info(f"Test class written to {output_filename}")
