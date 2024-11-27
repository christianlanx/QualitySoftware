from openai import OpenAI
from secrets import OPENAI_API_KEY

openai_client = OpenAI(api_key=OPENAI_API_KEY)

def submit_prompt_gpt(prompt: str, model: str = "gpt-4o-mini") -> str:
    """
    Submits a prompt to ChatGPT and returns the response message.
    
    Args:
        prompt (str): The prompt to submit.
        model (str): The model to use (default is "gpt-4o").

    Returns:
        str: The response message from ChatGPT.
    """
    try:
        completion = openai_client.chat.completions.create(
            model=model,
            messages=[
                {
                    "role": "user",
                    "content": [{"type": "text", "text": prompt}]
                }
            ]
        )
        return completion.choices[0].message.content

    except Exception as e:
        print(f"An error occurred: {e}")
        return ""