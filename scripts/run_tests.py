import subprocess
import sys
import os

def run_junit_tests(class_name, test_class_name=None):
    # Define the Maven command based on whether a test class is provided
    if test_class_name:
        mvn_cmd = ["mvn", "test", f"-Dtest={test_class_name}"]
        print(f"Running tests for specified test class '{test_class_name}'...")
    else:
        # If only a class name is provided, attempt to run all tests that match the class name
        mvn_cmd = ["mvn", "test", f"-Dtest=*{class_name}*"]
        print(f"Running tests for all test classes matching '{class_name}'...")

    try:
        # Execute the Maven command
        result = subprocess.run(mvn_cmd, capture_output=True, text=True, check=True)
        
        # Print Maven output
        print(result.stdout)
    except subprocess.CalledProcessError as e:
        print("An error occurred while running tests:")
        print(e.stdout)
        print(e.stderr)
        sys.exit(1)

if __name__ == "__main__":
    # Check for required arguments
    if len(sys.argv) < 2:
        print("Usage: python run_tests.py <class_name> [<test_class_name>]")
        sys.exit(1)

    # Get class name and optional test class name from arguments
    class_name = sys.argv[1]
    test_class_name = sys.argv[2] if len(sys.argv) > 2 else None

    # Run the JUnit tests
    run_junit_tests(class_name, test_class_name)
