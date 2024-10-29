import subprocess
import sys
import os

def run_pit_tests(class_name, test_class_name=None):
    # Define the Maven command for PIT based on whether a test class is provided
    if test_class_name:
        mvn_cmd = [
            "mvn", "org.pitest:pitest-maven:mutationCoverage",
            f"-DtargetClasses={class_name}",
            f"-DtargetTests={test_class_name}"
        ]
        print(f"Running PIT mutation tests for specified test class '{test_class_name}' on class '{class_name}'...")
    else:
        # Run PIT with all test classes related to the specified class
        mvn_cmd = [
            "mvn", "org.pitest:pitest-maven:mutationCoverage",
            f"-DtargetClasses={class_name}"
        ]
        print(f"Running PIT mutation tests for all test classes on class '{class_name}'...")

    try:
        # Execute the Maven command
        result = subprocess.run(mvn_cmd, capture_output=True, text=True, check=True)
        
        # Print Maven output
        print(result.stdout)
    except subprocess.CalledProcessError as e:
        print("An error occurred while running PIT mutation tests:")
        print(e.stdout)
        print(e.stderr)
        sys.exit(1)

if __name__ == "__main__":
    # Check for required arguments
    if len(sys.argv) < 2:
        print("Usage: python run_pit.py <class_name> [<test_class_name>]")
        sys.exit(1)

    # Get class name and optional test class name from arguments
    class_name = sys.argv[1]
    test_class_name = sys.argv[2] if len(sys.argv) > 2 else None

    # Run the PIT mutation tests
    run_pit_tests(class_name, test_class_name)
