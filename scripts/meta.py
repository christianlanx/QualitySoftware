# third party sdk
from meta_ai_api import MetaAI
# no api key needed :O
meta_ai = MetaAI()

def submit_prompt_meta(prompt: str) -> str:
    return meta_ai.prompt(message=prompt)["message"]
