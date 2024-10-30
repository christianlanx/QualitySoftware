import xml.etree.ElementTree as ET
import argparse
from collections import Counter, defaultdict

def parse_pit_report(report_path):
    # Parse the XML file
    tree = ET.parse(report_path)
    root = tree.getroot()

    # Initialize counters and summaries
    mutation_summary = Counter()
    mutator_details = defaultdict(list)

    for mutation in root.findall("mutation"):
        # Extract relevant attributes
        detected = mutation.get("detected", "false")
        status = mutation.get("status", "UNKNOWN")
        number_of_tests_run = mutation.get("numberOfTestsRun", "0")
        source_file = mutation.findtext("sourceFile", "Unknown")
        mutated_class = mutation.findtext("mutatedClass", "Unknown")
        mutated_method = mutation.findtext("mutatedMethod", "Unknown")
        line_number = mutation.findtext("lineNumber", "0")
        mutator = mutation.findtext("mutator", "Unknown")
        killing_test = mutation.findtext("killingTest", "None")
        description = mutation.findtext("description", "No description")

        # Update counters based on mutation status
        mutation_summary[status] += 1
        mutation_summary["total"] += 1
        if detected == "true":
            mutation_summary["detected"] += 1

        # Track mutator details for more in-depth analysis
        mutator_details[mutator].append({
            "source_file": source_file,
            "mutated_class": mutated_class,
            "mutated_method": mutated_method,
            "line_number": line_number,
            "status": status,
            "killing_test": killing_test,
            "description": description,
            "tests_run": number_of_tests_run
        })

    # Display summary of results
    print("PIT Mutation Report Summary")
    print("---------------------------")
    print(f"Total Mutations: {mutation_summary['total']}")
    print(f"Killed Mutations: {mutation_summary['KILLED']}")
    print(f"Survived Mutations: {mutation_summary['SURVIVED']}")
    print(f"Undetected (No Coverage): {mutation_summary['NO_COVERAGE']}")
    print(f"Detected Mutations: {mutation_summary['detected']}")
    print()

    # Display details by mutator type
    print("Mutation Details by Mutator:")
    for mutator, details in mutator_details.items():
        print(f"\nMutator: {mutator}")
        for detail in details:
            print(f"  - {detail['source_file']}:{detail['line_number']} - {detail['status']}")
            print(f"    Description: {detail['description']}")
            if detail["status"] == "KILLED":
                print(f"    Killing Test: {detail['killing_test']}")
            print(f"    Tests Run: {detail['tests_run']}")
            print()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Parse and summarize PIT mutation testing XML report.")
    parser.add_argument("report_path", help="Path to the PIT mutations.xml report file")
    args = parser.parse_args()

    parse_pit_report(args.report_path)
