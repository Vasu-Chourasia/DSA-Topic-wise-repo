import os
import requests
import subprocess
import re
from pathlib import Path

# -------- INPUT --------
url = input("Enter LeetCode problem URL: ").strip()
topic = input("Enter Topic Folder (example: 01-Arrays): ").strip()

# -------- CLEAN URL --------
url = url.split("?")[0]
slug = url.rstrip("/").split("/")[-1]

# -------- GRAPHQL API --------
api_url = "https://leetcode.com/graphql"

query = {
    "query": """
    query getQuestionDetail($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        title
        difficulty
        questionFrontendId
      }
    }
    """,
    "variables": {"titleSlug": slug}
}

response = requests.post(api_url, json=query)
data = response.json()

if not data.get("data") or not data["data"].get("question"):
    print("❌ Invalid URL or LeetCode API issue.")
    exit()

title = data["data"]["question"]["title"]
difficulty = data["data"]["question"]["difficulty"]
problem_number = data["data"]["question"]["questionFrontendId"]

# -------- CLEAN TITLE --------
clean_title = re.sub(r'[^a-zA-Z0-9]', '', title)
filename = f"{clean_title}_LeetCode_{problem_number}.java"

source = Path("solution.java")
destination = Path(topic) / filename

if not source.exists():
    print("❌ solution.java file not found!")
    exit()

source.rename(destination)

# -------- UPDATE README --------
readme_path = Path("README.md")

if readme_path.exists():
    content = readme_path.read_text()

    match = re.search(r"Total Problems Solved:\s*(\d+)", content)
    if match:
        count = int(match.group(1)) + 1
        content = re.sub(r"Total Problems Solved:\s*\d+",
                         f"Total Problems Solved: {count}",
                         content)
        readme_path.write_text(content)

# -------- GIT COMMANDS --------
subprocess.run(["git", "add", "."])
subprocess.run(["git", "commit", "-m",
                f"Added {title} (LC-{problem_number}) - {difficulty}"])
subprocess.run(["git", "push"])

print("\n✅ Uploaded Successfully ")