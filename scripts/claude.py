import anthropic
from secrets import ANTHROPIC_API_KEY

anthropic_client = anthropic.Anthropic(api_key=ANTHROPIC_API_KEY)

def submit_prompt_anthropic(prompt: str, model: str = "claude-3-5-sonnet-latest") -> str:
    message = anthropic_client.messages.create(
        model=model,
        max_tokens=4000,
        messages=[
            {
                "role": "user",
                "content": [
                    {
                        "type": "text",
                        "text": prompt
                    }
                ]
            }
        ]
    )
    return message.content[0].text