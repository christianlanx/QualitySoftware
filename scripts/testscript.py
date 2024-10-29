#!/usr/bin/python

import os
import re
import sys
import subprocess
import csv

# Check if a class under test is provided as an argument
if len(sys.argv) < 2:
    print("Usage: python test_script.py <class_under_test>")
    sys.exit(1)

class_under_test = sys.argv[1]
test_dir = f"./src/test/java/{class_under_test}"

# Validate the class name
if not os.path.exists(test_dir):
    print("Error: class not found")
    print("Available classes are as follows")

# List all test classes in the test directory
test_classes = [f for f in os.listdir(test_dir) if f.endswith(".java")]

for test_class in test_classes:
    # Strip the .java extension to get the test class name
    test_class_name = os.path.splitext(test_class)[0]

    # Run the Maven test command
    print(f"Testing {test_class_name}")
    subprocess.run(
        ["mvn", "clean", "test", "jacoco:report", f"-Dtest=trityp.{test_class_name}"],
        stdout=subprocess.DEVNULL,
        stderr=subprocess.DEVNULL
    )

    # Define the path to the surefire report XML
    report_file = f"target/surefire-reports/TEST-trityp.{test_class_name}.xml"

    if os.path.isfile(report_file):
        # Parse the XML report for test results using regex
        with open(report_file, "r") as file:
            content = file.read()

            num_tests = re.search(r'tests="(\d+)"', content)
            num_failures = re.search(r'failures="(\d+)"', content)
            num_errors = re.search(r'errors="(\d+)"', content)
            num_skipped = re.search(r'skipped="(\d+)"', content)
            test_time = re.search(r'time="([\d.]+)"', content)

            # Extract values or default to 'N/A'
            num_tests = num_tests.group(1) if num_tests else "N/A"
            num_failures = num_failures.group(1) if num_failures else "N/A"
            num_errors = num_errors.group(1) if num_errors else "N/A"
            num_skipped = num_skipped.group(1) if num_skipped else "N/A"
            test_time = test_time.group(1) if test_time else "N/A"

        # Path to JaCoCo CSV report
        jacoco_csv = "target/site/jacoco/jacoco.csv"
        instr_coverage = line_coverage = branch_coverage = "N/A"

        # Parse the CSV for coverage metrics if the file exists
        if os.path.isfile(jacoco_csv):
            with open(jacoco_csv, "r") as csvfile:
                reader = csv.reader(csvfile)
                for row in reader:
                    if row[2] == class_under_test:
                        instr_missed = int(row[3])
                        instr_covered = int(row[4])
                        branch_missed = int(row[5])
                        branch_covered = int(row[6])
                        line_missed = int(row[7])
                        line_covered = int(row[8])

                        # Calculate instruction coverage
                        instr_total = instr_covered + instr_missed
                        instr_coverage = (
                            f"{(instr_covered / instr_total) * 100:.2f}" if instr_total > 0 else "N/A"
                        )

                        # Calculate line coverage
                        line_total = line_covered + line_missed
                        line_coverage = (
                            f"{(line_covered / line_total) * 100:.2f}" if line_total > 0 else "N/A"
                        )

                        # Calculate branch coverage
                        branch_total = branch_covered + branch_missed
                        branch_coverage = (
                            f"{(branch_covered / branch_total) * 100:.2f}" if branch_total > 0 else "N/A"
                        )

                        break  # Stop after finding the relevant class

        # Print the parsed test and coverage results
        print(f"Results for {test_class_name}:")
        print(f"  Number of tests: {num_tests}")
        print(f"  Failures: {num_failures}")
        print(f"  Errors: {num_errors}")
        print(f"  Skipped: {num_skipped}")
        print(f"  Time taken (seconds): {test_time}")
        print(f"  Instruction coverage: {instr_coverage}%")
        print(f"  Line coverage: {line_coverage}%")
        print(f"  Branch coverage: {branch_coverage}%")
        print("-------------------------------")
    else:
        print(f"No report found for {test_class_name}")
