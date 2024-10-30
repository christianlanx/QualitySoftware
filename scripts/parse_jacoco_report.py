#!/usr/bin/python3
import xml.etree.ElementTree as ET
import argparse

def parse_jacoco(jacoco_path, target_package=None, target_class=None):
    try:
        tree = ET.parse(jacoco_path)
        root = tree.getroot()

        # Find the package(s) matching the target package or class
        for package in root.findall('package'):
            package_name = package.get('name')
            if target_package and package_name != target_package:
                continue

            print(f"\nPackage: {package_name}")
            
            # Find each class in the package
            for cls in package.findall('class'):
                class_name = cls.get('name').replace('/', '.')
                if target_class and not class_name.endswith(target_class):
                    continue

                print(f"  Class: {class_name}")

                # Extract coverage metrics
                metrics = {}
                for counter in cls.findall('counter'):
                    counter_type = counter.get('type')
                    missed = int(counter.get('missed'))
                    covered = int(counter.get('covered'))
                    total = missed + covered
                    coverage = (covered / total * 100) if total > 0 else 0
                    metrics[counter_type] = coverage

                # print metrics
                if (instruction_coverage := metrics.get('INSTRUCTION')):
                    instruction_coverage = f"{instruction_coverage:.2f}%"
                else:
                    instruction_coverage = 'N/A'
                print(f"    Instruction Coverage: {instruction_coverage}")
                if (branch_coverage := metrics.get("BRANCH")):
                    branch_coverage = f"{branch_coverage:.2f}%"
                else:
                    branch_coverage = "N/A"
                print(f"    Branch Coverage: {branch_coverage}")
                if (line_coverage := metrics.get('LINE')):
                    line_coverage = f"{line_coverage:.2f}%"
                else:
                    line_coverage = "N/A"
                print(f"    Line Coverage: {line_coverage}")

    except ET.ParseError:
        print("Error: Could not parse jacoco.xml. Check if the file is valid XML.")
    except FileNotFoundError:
        print(f"Error: File {jacoco_path} not found. Ensure the file path is correct.")

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Parse JaCoCo coverage metrics.")
    parser.add_argument("jacoco_path", help="Path to the jacoco.xml file")
    parser.add_argument("--package", help="Filter by package name")
    parser.add_argument("--class_name", help="Filter by class name (without package)")

    args = parser.parse_args()

    # Run the parser
    parse_jacoco(args.jacoco_path, target_package=args.package, target_class=args.class_name)
