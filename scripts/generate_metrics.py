import argparse
import json
import os
import re
import subprocess
import shutil
import xml.etree.ElementTree as ET
from typing import Union

# Import tqdm for the progress bar
from tqdm import tqdm

from project import *

ROOT_PATH = 'maven_project'
CLASS_PATH = os.path.join(ROOT_PATH, "src", "main", "java")
TEST_PATH = os.path.join(ROOT_PATH, "src", "test", "java")
TARGET_PATH = os.path.join(ROOT_PATH, "target")
JACOCO_DIR_PATH = os.path.join(TARGET_PATH, "site", "jacoco")
JACOCO_EXEC_PATH = os.path.join(TARGET_PATH, "jacoco.exec")
JACOCO_REPORT_PATH = os.path.join(JACOCO_DIR_PATH, "jacoco.xml")
PIT_DIR_PATH = os.path.join(TARGET_PATH, "pit-reports")
METRICS_PATH = 'metrics.json'

def run_maven_clean(verbose=False):
    """Clean the project to remove any existing compiled classes and any existing reports."""
    if verbose:
        print("Cleaning project...")
    result = subprocess.run(["mvn", "clean"], capture_output=not verbose, text=True, cwd=ROOT_PATH)
    if result.returncode != 0:
        print("Error cleaning project")
        if verbose:
            print(result.stderr)
    elif verbose:
        print("Clean successful.")

def run_maven_compile(verbose=False):
    """Compile all classes in the project"""
    if verbose:
        print("Compiling project...")
    result = subprocess.run(["mvn", "compile"], capture_output=not verbose, text=True, cwd=ROOT_PATH)
    if result.returncode != 0:
        print("Error during compilation:")
        if verbose:
            print(result.stderr)
    elif verbose:
        print("Compilation successful.")

def run_maven_test_compile(verbose=False):
    """Compile all test classes in the project"""
    if verbose:
        print("Compiling project test classes...")
    result = subprocess.run(["mvn", "test-compile"], capture_output=not verbose, text=True, cwd=ROOT_PATH)
    if result.returncode != 0:
        print("Error during test compilation:")
        if verbose:
            print(result.stdout)
            print(result.stderr)
    elif verbose:
        print("Test compilation successful.")

def collect_static_metrics(testclass_file_path: Union[str, bytes]) -> StaticMetrics:
    """
    Collect static metrics from a Java test class file.
    """
    num_lines = 0
    num_tests = 0
    num_assertions = 0
    try:
        with open(testclass_file_path, 'r') as file:
            for line in file:
                # Increment line count
                num_lines += 1

                # Look for test annotations (JUnit 4/5)
                if re.search(r"@\b(Test|ParameterizedTest)\b", line):
                    num_tests += 1

                # Look for common assertion methods
                if re.search(r"\bassert(?:True|False|Equals|NotEquals|Null|NotNull|Same|NotSame|That)\b", line):
                    num_assertions += 1

    except FileNotFoundError:
        print(f"Error: File not found at {testclass_file_path}")
    except Exception as e:
        print(f"An error occurred while processing the file: {e}")
    return StaticMetrics(num_lines, num_tests, num_assertions)

def collect_test_metrics(testclass_path: str, verbose=False) -> TestMetrics:
    maven_command = ["mvn", f"-Dtest={testclass_path}", "test"]
    try:
        result = subprocess.run(maven_command, capture_output=not verbose, text=True, cwd=ROOT_PATH)
        output = result.stdout
        error_output = result.stderr
        match = re.search(r"Tests run: (\d+), Failures: (\d+), Errors: (\d+), Skipped: (\d+)", result.stdout)
        if match:
            total = int(match.group(1))
            failed = int(match.group(2)) + int(match.group(3))  # Failures and Errors
            skipped = int(match.group(4))
            passed = total - failed - skipped
            return TestMetrics(total, passed, failed, skipped)
        else:
            if verbose:
                print(f"Output:\n{output}")
                print(f"Error Output:\n{error_output}")
                print("Error: Unable to parse Maven test output")
            return TestMetrics(0, 0, 0, 0)
    except Exception as e:
        print(f"Error running test class {testclass_path}: {e}")
        return TestMetrics(0, 0, 0, 0)

def collect_coverage_metrics(testclass_path: str, target_package: str, class_under_test: str, verbose=False) -> JacocoMetrics:
    """
    Collect JaCoCo coverage metrics for a single test class.
    """
    # Clean up previous JaCoCo data
    jacoco_exec_path = os.path.join(TARGET_PATH, "jacoco.exec")
    jacoco_report_dir = os.path.join(TARGET_PATH, "site", "jacoco")
    if os.path.exists(jacoco_exec_path):
        os.remove(jacoco_exec_path)
    if os.path.exists(jacoco_report_dir):
        shutil.rmtree(jacoco_report_dir)

    # Run JaCoCo for the specific test class
    maven_command = [
        "mvn",
        "test",
        "jacoco:report",
        f"-Dtest={testclass_path}",
    ]
    if verbose:
        print(f"\tRunning JaCoCo: {' '.join(maven_command)}")
    result = subprocess.run(maven_command, capture_output=not verbose, text=True, cwd=ROOT_PATH)
    if result.returncode != 0:
        if verbose:
            print(f"Error while running tests for {testclass_path}:")
            print(result.stderr)
        return JacocoMetrics(counters={})

    # Check if the test ran
    if "Tests run: 0" in result.stdout:
        if verbose:
            print(f"Error: No tests were executed for {testclass_path}.")
        return JacocoMetrics(counters={})

    # Parse the JaCoCo XML report
    try:
        tree = ET.parse(JACOCO_REPORT_PATH)
        root = tree.getroot()

        # Locate the package
        target_package_element = None
        packages = root.findall('package')
        for package_elem in packages:
            package_name = package_elem.get('name')
            if package_name == target_package:
                target_package_element = package_elem
                break
        else:
            if verbose:
                print(f"Error: Package {target_package} not found in JaCoCo report.")
            return JacocoMetrics(counters={})

        # Locate the class
        target_class_element = None
        for class_element in target_package_element.findall('class'):
            class_name = class_element.get('name').replace('/', '.')
            if class_name == f"{target_package}.{class_under_test}":
                target_class_element = class_element
                break
        if target_class_element is None:
            if verbose:
                print(f"Error: Class {class_under_test} not found in JaCoCo report.")
            return JacocoMetrics(counters={})

        # Extract counters for the class
        counters = {}
        for counter in target_class_element.findall('counter'):
            counter_type = counter.get('type')
            missed = int(counter.get('missed'))
            covered = int(counter.get('covered'))
            total = missed + covered
            coverage = (covered / total * 100) if total > 0 else 0
            counters[counter_type] = JacocoCounter(counter_type, total, covered, missed, coverage)

        return JacocoMetrics(counters=counters)

    except ET.ParseError:
        if verbose:
            print(f"Error: Unable to parse {JACOCO_REPORT_PATH}.")
    except FileNotFoundError:
        if verbose:
            print(f"Error: {JACOCO_REPORT_PATH} not found.")
    return JacocoMetrics(counters={})

def collect_mutation_metrics(testclass_path: str, class_under_test: str, package: str, verbose=False) -> PitMetrics:
    """
    Collect PIT mutation metrics for a single test class.
    """
    # Define the report path
    report_path = os.path.join(TARGET_PATH, "pit-reports", "mutations.xml")

    # Clean up previous PIT reports
    if os.path.exists(report_path):
        os.remove(report_path)

    # Run PIT mutation testing for the specific test class
    pit_command = [
        "mvn", "org.pitest:pitest-maven:mutationCoverage",
        f"-DtargetClasses={package}.{class_under_test}",
        f"-DtargetTests={testclass_path}",
    ]
    if verbose:
        print(f"\tRunning PIT: {' '.join(pit_command)}")
    result = subprocess.run(pit_command, capture_output=not verbose, text=True, cwd=ROOT_PATH)

    if result.returncode != 0:
        if verbose:
            print("Error during PIT execution:")
            print(result.stdout)
            print(result.stderr)
        return PitMetrics(totals={}, mutators={})

    # Check if the report file exists after execution
    if not os.path.exists(report_path):
        if verbose:
            print("Error: PIT report file not generated.")
        return PitMetrics(totals={}, mutators={})

    # Parse the PIT mutations XML report
    try:
        tree = ET.parse(report_path)
        root = tree.getroot()
        pit_metrics = PitMetrics(totals={}, mutators={})

        # Extract mutation information
        for mutation in root.findall("mutation"):
            mutator_name = mutation.findtext("mutator")
            if mutator_name not in pit_metrics.mutators:
                pit_metrics.mutators[mutator_name] = PitMutator(
                    name=mutator_name,
                    tests_run=0,
                    killed=0,
                    survived=0,
                    detected=0,
                    undetected=0,
                    no_coverage=0
                )
            mutator = pit_metrics.mutators[mutator_name]
            mutator.tests_run += 1
            status = mutation.get("status")
            detected = mutation.get("detected", "false") == "true"
            if status == "KILLED":
                mutator.killed += 1
            elif status == "SURVIVED":
                mutator.survived += 1
            elif status == "NO_COVERAGE":
                mutator.no_coverage += 1
            if detected:
                mutator.detected += 1
            else:
                mutator.undetected += 1

        # Aggregate totals
        for mutator in pit_metrics.mutators.values():
            pit_metrics.totals["killed"] = pit_metrics.totals.get("killed", 0) + mutator.killed
            pit_metrics.totals["survived"] = pit_metrics.totals.get("survived", 0) + mutator.survived
            pit_metrics.totals["no_coverage"] = pit_metrics.totals.get("no_coverage", 0) + mutator.no_coverage
            pit_metrics.totals["detected"] = pit_metrics.totals.get("detected", 0) + mutator.detected
            pit_metrics.totals["undetected"] = pit_metrics.totals.get("undetected", 0) + mutator.undetected

        return pit_metrics

    except ET.ParseError as e:
        if verbose:
            print(f"Error parsing PIT report: {e}")
    except Exception as e:
        if verbose:
            print(f"An unexpected error occurred while parsing the PIT report: {e}")

    return PitMetrics(totals={}, mutators={})

if __name__ == "__main__":
    # Inputs
    all_metrics = ["static", "test", "coverage", "mutation"]
    parser = argparse.ArgumentParser(description="Collect metrics for all generated test classes")
    parser.add_argument("--package", type=str, default=None, choices=all_packages,
                        help="Filter test classes by package")
    parser.add_argument("--llm", type=str, default=None, choices=all_llms,
                        help="Filter test classes by LLM")
    parser.add_argument("--prompt", type=str, default=None, choices=all_prompts,
                        help="Filter test classes by prompt")
    parser.add_argument("--metric_types", type=str, nargs='+', default=all_metrics, choices=all_metrics,
                        help="Select which types of metrics to collect")
    parser.add_argument("--overwrite", action="store_true", help="Overwrite with new metrics, leaving other metrics")
    parser.add_argument("--overwrite_all", action="store_true", help="Erase all existing metrics, only save new metrics")
    parser.add_argument("--print", action="store_true", help="Print the collected metrics instead of saving")
    parser.add_argument("--verbose", action="store_true", help="Enable verbose output")
    args = parser.parse_args()

    packages = [args.package] if args.package else all_packages
    prompts = [args.prompt] if args.prompt else all_prompts
    llms = [args.llm] if args.llm else all_llms

    # Load existing metrics
    metrics = {}
    if not args.overwrite_all:
        file_path = METRICS_PATH
        if os.path.exists(file_path):
            with open(file_path, 'r') as file:
                metrics = json.load(file)

    all_test_classes = []
    total_iterations = len(packages) * len(llms) * len(prompts)
    progress_bar = tqdm(total=total_iterations, disable=args.verbose)

    for package in packages:
        class_under_test = None
        for cls, details in all_classes.items():
            if details.get("package") == package:
                class_under_test = cls
                class_path = f"{package}.{class_under_test}"
                break
        if not class_under_test:
            print(f"Error, class under test not found for package {package}")
            continue
        for llm in llms:
            for prompt in prompts:
                run_maven_clean(verbose=args.verbose)
                run_maven_compile(verbose=args.verbose)
                run_maven_test_compile(verbose=args.verbose)
                if args.verbose:
                    print(f"Collecting metrics for {package} {llm} {prompt}")
                testclass_dir_path = os.path.join(TEST_PATH, package, llm, prompt)
                if not os.path.exists(testclass_dir_path):
                    if args.verbose:
                        print(f"Error: path does not exist {testclass_dir_path}")
                    progress_bar.update(1)
                    continue
                testclasses = os.listdir(testclass_dir_path)
                if len(testclasses) > 1:
                    if args.verbose:
                        print(f"Error: multiple test classes detected for path {testclass_dir_path}: {testclasses}")
                    progress_bar.update(1)
                    continue
                testclass = testclasses[0]
                index = testclass.find('.java')
                if index == -1:
                    if args.verbose:
                        print(f"Error: file is not a java file under path {testclass_dir_path} for file {testclass}")
                    progress_bar.update(1)
                    continue
                testclass = testclass[:index]
                testclass_path = f"{package}.{llm}.{prompt}.{testclass}"
                testclass_file_path = os.path.join(testclass_dir_path, f"{testclass}.java")

                # Initialize a dictionary to hold metrics for this test class
                test_class_metrics = {}

                # Collect static metrics
                if "static" in args.metric_types:
                    static_metrics = collect_static_metrics(testclass_file_path)
                    if args.verbose:
                        print(static_metrics)
                    test_class_metrics['static'] = static_metrics.to_dict()
                else:
                    static_metrics = None

                # Collect test execution metrics
                if "test" in args.metric_types:
                    test_metrics = collect_test_metrics(testclass_path, verbose=args.verbose)
                    if args.verbose:
                        print(test_metrics)
                    test_class_metrics['test'] = test_metrics.to_dict()
                else:
                    test_metrics = None

                # Collect coverage metrics
                if "coverage" in args.metric_types:
                    jacoco_metrics = collect_coverage_metrics(testclass_path, package, class_under_test, verbose=args.verbose)
                    if args.verbose:
                        print(jacoco_metrics)
                    test_class_metrics['jacoco'] = jacoco_metrics.to_dict()
                else:
                    jacoco_metrics = None

                # Collect mutation metrics
                if "mutation" in args.metric_types:
                    if test_metrics and test_metrics.tests_failed == 0:
                        pit_metrics = collect_mutation_metrics(testclass_path, class_under_test, package, verbose=args.verbose)
                        if args.verbose:
                            print(pit_metrics)
                        test_class_metrics['pit'] = pit_metrics.to_dict()
                    else:
                        if args.verbose:
                            print("Skipping PIT metrics due to failed tests")
                else:
                    pit_metrics = None

                # Update the metrics dictionary
                # Create a unique key for the test class
                test_class_key = f"{package}.{llm}.{prompt}.{testclass}"
                metrics[test_class_key] = test_class_metrics

                # **Write metrics to file after each test class**
                if not args.print:
                    with open(METRICS_PATH, 'w') as file:
                        json.dump(metrics, file, indent=4)

                progress_bar.update(1)

    progress_bar.close()

    # Output the collected metrics if the --print option is used
    if args.print:
        print(json.dumps(metrics, indent=4))
