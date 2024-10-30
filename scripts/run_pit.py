import subprocess
import sys
import os

def run_maven_clean():
    """Clean the project to remove any existing compiled classes and any existing reports."""
    print("Cleaning project...")
    result = subprocess.run(["mvn", "clean"], capture_output=True, text=True)
    if result.returncode != 0:
        print("Error cleaning project")
        print(result.stderr)
        sys.exit(1)
    print("Clean successful.")

def run_maven_compile():
    """Compile all classes in the project"""
    print("Compiling project...")
    result = subprocess.run(["mvn", "compile"], capture_output=True, text=True)
    if result.returncode != 0:
        print("Error during compilation:")
        print(result.stderr)
        sys.exit(1)
    print("Compilation successful.")

def run_maven_test_compile():
    """Compile all test classes in the project"""
    print("Compiling project test classes...")
    result = subprocess.run(["mvn", "test-compile"], capture_output=True, text=True)
    if result.returncode != 0:
        print("Error during test compilation:")
        print(result.stderr)
        sys.exit(1)
    print("Test compilation successful.")

def run_pit(target_class, target_test):
    """Run PIT mutation testing for a specific target class and test class."""
    print(f"Running PIT for class '{target_class}' with test '{target_test}'...")
    
    # Construct the PIT command
    pit_command = [
        "mvn", "org.pitest:pitest-maven:mutationCoverage",
        f"-DtargetClasses={target_class}",
        f"-DtargetTests={target_test}",
        "-Dverbose=true"  # Optional: add for more detailed output
    ]

    # Execute the PIT command
    result = subprocess.run(pit_command, capture_output=True, text=True)
    if result.returncode != 0:
        print("Error during PIT execution:")
        print(result.stderr)
        sys.exit(1)
    
    # Print PIT output
    print("PIT run successful.")
    print(result.stdout)

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Usage: python run_pit.py <target_class> <target_test>")
        sys.exit(1)
    
    target_class = sys.argv[1]
    target_test = sys.argv[2]

    run_maven_clean()
    run_maven_compile()
    run_maven_test_compile()
    run_pit(target_class, target_test)
