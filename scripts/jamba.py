from ai21 import AI21Client, AI21APIError
from ai21.models.chat import UserMessage
from ai21 import errors as ai21_errors
from secrets import JAMBA_API_KEY

# One way of passing your key to the client.
client = AI21Client(api_key=JAMBA_API_KEY)

# Another way to set your key is by setting the AI21_API_KEY
# environment variable to your key value. The default value
# of api_key in the constructor is os.environ["AI21_API_KEY"]. So:
# import os
# os.environ["AI21_API_KEY"] =  <YOUR_API_KEY>
# client = AI21Client();

def submit_prompt_jamba(prompt: str, model: str="jamba-1.5-mini"):
    messages = [
        UserMessage(
            content=prompt
        )
    ]
    try:
        response = client.chat.completions.create(
            model=model,
            messages=messages,
            top_p=1.0 # Setting to 1 encourages different responses each call.
        )
    except ai21_errors.AI21ServerError as e:
        print("Server error and could not be reached")
        print(e.details)
    except ai21_errors.TooManyRequestsError as e:
        print("A 429 status code was returned. Slow down on the requests")
    except AI21APIError as e:
        print("A non 200 status code error. For more error types see ai21.errors")
        print(response.to_json())
    return response.choices[0].message.content
