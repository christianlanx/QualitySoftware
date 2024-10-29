# Check if a class under test is provided as an argument
if [ -z "$1" ]; then
    echo "Usage: $0 <class_under_test>"
    exit 1
fi
class=$1
testdir="./src/test/java/$class"

for testclass in $(ls ./src/test/java/trityp/); do 
    # Strip the .java extension to get the test class name
    testclass_name="${testclass%.java}"
    
    # Determine the class under test (in this case it's 'Trityp', but adjust this based on your naming convention)
    class_under_test="Trityp"  # Modify this if needed to dynamically determine the class under test

    # Run the tests for the current test class and suppress the output
    echo "Testing $testclass_name"
    mvn clean test jacoco:report -Dtest=trityp.$testclass_name > /dev/null

    # Define the path to the surefire report XML (assuming default Maven behavior)
    report_file="target/surefire-reports/TEST-trityp.${testclass_name}.xml"

    if [ -f "$report_file" ]; then
        # Extract the number of tests, failures, and time from the first <testsuite> element
        num_tests=$(grep -oP '(?<=tests=")[0-9]+' "$report_file" | head -n 1)
        num_failures=$(grep -oP '(?<=failures=")[0-9]+' "$report_file" | head -n 1)
        num_errors=$(grep -oP '(?<=errors=")[0-9]+' "$report_file" | head -n 1)
        num_skipped=$(grep -oP '(?<=skipped=")[0-9]+' "$report_file" | head -n 1)
        test_time=$(grep -oP '(?<=time=")[0-9.]+' "$report_file" | head -n 1)

        # Path to JaCoCo CSV report
        jacoco_csv="target/site/jacoco/jacoco.csv"

        if [ -f "$jacoco_csv" ]; then
            # Extract the coverage metrics for the specific class under test from the CSV
            csv_line=$(grep ",$class_under_test," "$jacoco_csv" | head -n 1)

            if [ -n "$csv_line" ]; then
                # Parse the CSV line to get the missed/covered metrics
                IFS=',' read -r group package class instr_missed instr_covered branch_missed branch_covered line_missed line_covered complexity_missed complexity_covered method_missed method_covered <<< "$csv_line"

                # Calculate instruction coverage
                instr_total=$((instr_covered + instr_missed))
                if [ "$instr_total" -gt 0 ]; then
                    instr_coverage=$(awk "BEGIN {print $instr_covered / $instr_total * 100}")
                else
                    instr_coverage="N/A"
                fi

                # Calculate line coverage
                line_total=$((line_covered + line_missed))
                if [ "$line_total" -gt 0 ]; then
                    line_coverage=$(awk "BEGIN {print $line_covered / $line_total * 100}")
                else
                    line_coverage="N/A"
                fi

                # Calculate branch coverage
                branch_total=$((branch_covered + branch_missed))
                if [ "$branch_total" -gt 0 ]; then
                    branch_coverage=$(awk "BEGIN {print $branch_covered / $branch_total * 100}")
                else
                    branch_coverage="N/A"
                fi
            else
                instr_coverage="N/A"
                line_coverage="N/A"
                branch_coverage="N/A"
            fi
        else
            instr_coverage="N/A"
            line_coverage="N/A"
            branch_coverage="N/A"
        fi

        # Print the parsed test and coverage results
        echo "Results for $testclass_name:"
        echo "  Number of tests: $num_tests"
        echo "  Failures: $num_failures"
        echo "  Errors: $num_errors"
        echo "  Skipped: $num_skipped"
        echo "  Time taken (seconds): $test_time"
        echo "  Instruction coverage: $instr_coverage%"
        echo "  Line coverage: $line_coverage%"
        echo "  Branch coverage: $branch_coverage%"
        echo "-------------------------------"
    else
        echo "No report found for $testclass_name"
    fi
done

