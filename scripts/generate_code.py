import argparse
import os
import re
import logging
import sys
from concurrent.futures import ThreadPoolExecutor, as_completed

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


def generate_prompt_text(prompt: str, package: str, llm: str) -> str:
    # get the base of the prompt text
    prompt_text_base_path = os.path.join("prompts", f"{prompt}.txt")
    with open(prompt_text_base_path, 'r') as file:
        prompt_text = file.read()
    # add an instruction to include the package statement
    package_instruction = f"Include the following package statement: 'package {package}.{llm}.{prompt};'\n"
    prompt_text += package_instruction

    if prompt == "black":
        prompt_text += "\nProblem Description:\n"
        description_path = os.path.join("prompts", package, "description.txt")
        with open(description_path, 'r') as file:
            prompt_text += file.read()
        prompt_text += "\nClass Signature:\n"
        signature_path = os.path.join("prompts", package, "signature.txt")
        with open(signature_path, 'r') as file:
            prompt_text += file.read()
    elif prompt == "grey":
        prompt_text += "\nProblem Description:\n"
        description_path = os.path.join("prompts", package, "description.txt")
        with open(description_path, 'r') as file:
            prompt_text += file.read()
        prompt_text += "\nSolution Implementation\n"
        solution_path = os.path.join("maven_project", "src", "main", "java", package)
        files = os.listdir(solution_path)
        if len(files) != 1:
            print(f"Error: expected only one file at path {solution_path}. Found {files}")
            sys.exit(1)
        solution_path = os.path.join(solution_path, files[0])
        with open(solution_path, 'r') as file:
            prompt_text += file.read()
    elif prompt == "white":
        prompt_text += "\nImplementation: \n"
        # retrieve the class implementation
        solution_path = os.path.join("maven_project", "src", "main", "java", package)
        files = os.listdir(solution_path)
        if len(files) != 1:
            print(f"Error: expected only one file at path {solution_path}. Found {files}")
            sys.exit(1)
        solution_path = os.path.join(solution_path, files[0])
        with open(solution_path, 'r') as file:
            prompt_text += file.read()
    else:
        print(f"Error: unexpected prompt {prompt}")
        sys.exit(1)
    return prompt_text


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

    print(response_text)

    start_index = response_text.find("package")
    if start_index == -1:
        logging.error("Failed to parse Java code: Start marker not found.")
        return None
    end_index = response_text.rfind("}")
    if end_index == -1:
        logging.error("Failed to parse Java code: End marker not found.")
        return None

    generated_test_class = response_text[start_index:end_index + 1]
    return generated_test_class

def process_task(package: str, llm: str, prompt: str, args) -> None:
    logging.info(f"Generating for package={package}, LLM={llm}, prompt={prompt}")
    prompt_text = generate_prompt_text(prompt, package, llm)
    if not prompt_text:
        return

    testclass_path = os.path.join(TEST_CLASS_BASE_PATH, package, llm, prompt)
    os.makedirs(testclass_path, exist_ok=True)

    files = os.listdir(testclass_path)
    if files and not args.overwrite:
        logging.info(f"Skipping: Test class already exists in {testclass_path}")
        return

    generated_test_class = generate_test_class(prompt, prompt_text, llm)
    if not generated_test_class:
        return

    if args.print:
        print(generated_test_class)
    else:
        match = re.search(r'\bclass (\w+)', generated_test_class)
        if not match:
            logging.error("Class name not found in the generated code.")
            return
        class_name = match.group(1)
        output_filename = os.path.join(testclass_path, f"{class_name}.java")
        with open(output_filename, 'w') as file:
            file.write(generated_test_class)
        logging.info(f"Test class written to {output_filename}")

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
    parser.add_argument("--max_workers", type=int, default=4, help="Number of parallel workers.")
    args = parser.parse_args()

    packages = [args.package] if args.package else all_packages
    prompts = [args.prompt] if args.prompt else all_prompts
    llms = [args.llm] if args.llm else all_llms

    tasks = [(package, llm, prompt) for package in packages for llm in llms for prompt in prompts]

    # Use ThreadPoolExecutor or ProcessPoolExecutor for parallelization
    # ThreadPoolExecutor is often simpler if your tasks are I/O bound (network requests).
    with ThreadPoolExecutor(max_workers=args.max_workers) as executor:
        futures = [executor.submit(process_task, package, llm, prompt, args) for package, llm, prompt in tasks]
        for future in as_completed(futures):
            # If any task raises an exception, log it
            exc = future.exception()
            if exc:
                logging.error(f"Task failed with exception: {exc}")
