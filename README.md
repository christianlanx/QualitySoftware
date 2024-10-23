# Quality Software
Project for testing quality of LLM generated software tests in Java Junit.

# Build
## Docker container
`docker build -t ubuntu20.04_openjdk21 .`

# Test
## Run docker container
`docker run -it ubuntu20.04_openjdk21`

## Run test script
`./testscript.sh`

## Run test classes in maven
Example, run a particular test class: `mvn test -Dtest=trityp.TritypTestCopilot`

Once you've verified you can build and run the tests, try using testscript.sh

# Get Metrics

# Trityp
Triangle Tester Class. Takes three integers and returns the type of triangle

# Etc
More software under test to be added


