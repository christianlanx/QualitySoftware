# Prompts
This directory contains the different prompts that are used in this project to generate the various test cases.

Prompts follow a general template but may be customized for each particular test class.

Prompts are organized by class under test.

## Prompt 0
Prompt 0 was our first, most naive prompt. Test classes generated with this prompt have some variance and required a bit of modification in order to work, as the prompt was under specified. Test classes generated with prompt 0 were generated manually without the use of automation.

Prompt 0 simply states "Write me a test suite to cover this code: ", followed by the full source code of the class under test.

## Prompt 1
Prompt 1 was our first automated prompt. The approach was to replicate the simplicity of prompt 0, but to include some specifications which would remove the variability seen in the results generated from prompt 0.