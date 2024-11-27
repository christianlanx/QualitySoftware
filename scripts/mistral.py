from mistralai import Mistral
from secrets import MISTRAL_API_KEY

client = Mistral(api_key=MISTRAL_API_KEY)

def submit_prompt_mistral(prompt: str, model: str = "mistral-large-latest") -> str:
    chat_response = client.chat.complete(
        model = model,
        messages = [
            {
                "role": "user",
                "content": prompt,
            },
        ]
    )
    return chat_response.choices[0].message.content