# Quality Software
Project for testing quality of LLM generated software tests in Java Junit.


---
# Running unit tests

## Run test script
-work in progress-

## Run test classes in maven
Example, run a particular test class: `mvn test -Dtest=trityp.TritypTestCopilot`

Once you've verified you can build and run the tests, try using testscript.sh

## Run tests with PIT
Example, running a single test class: `mvn org.pitest:pitest-maven:mutationCoverage -DtargetTests=trityp.TritypTestCopilot -DtargetClasses=trityp.Trityp`

---
# Get Metrics
Work in progress

--- 
# Classes Under Test

## Trityp
Triangle Tester Class. Takes three integers and returns the type of triangle

# Etc
More software under test to be added

---

# Docker (unused)

## Docker container
`docker build -t ubuntu20.04_openjdk21 .`

# Test
## Run docker container
`docker run -it ubuntu20.04_openjdk21`
