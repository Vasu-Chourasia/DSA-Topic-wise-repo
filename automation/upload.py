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

# -------- UPDATE README COUNTERS --------
readme_path = Path("README.md")

if readme_path.exists():
    content = readme_path.read_text()

    # Update Total
    total_match = re.search(r"Total Problems Solved:\s*(\d+)", content)
    if total_match:
        total_count = int(total_match.group(1)) + 1
        content = re.sub(r"Total Problems Solved:\s*\d+",
                         f"Total Problems Solved: {total_count}",
                         content)

    # Update Difficulty Counter
    diff_match = re.search(rf"{difficulty}:\s*(\d+)", content)
    if diff_match:
        diff_count = int(diff_match.group(1)) + 1
        content = re.sub(rf"{difficulty}:\s*\d+",
                         f"{difficulty}: {diff_count}",
                         content)

    readme_path.write_text(content)

# -------- GIT COMMANDS --------
def run_git_command(command):
    result = subprocess.run(command, capture_output=True, text=True)
    if result.returncode != 0:
        print(f"\n❌ Error running: {' '.join(command)}")
        print(result.stderr)
        exit()
    return result

run_git_command(["git", "add", "."])
run_git_command(["git", "commit", "-m",
                f"Added {title} (LC-{problem_number}) - {difficulty}"])

# Try pushing
push_result = subprocess.run(["git", "push"], capture_output=True, text=True)

if push_result.returncode != 0:
    print("\n⚠️ Push failed. Attempting to rebase and retry...")
    
    run_git_command(["git", "pull", "origin", "main", "--rebase"])
    run_git_command(["git", "push"])
    
    print("\n✅ Uploaded Successfully after rebase!")
else:
    print("\n✅ Uploaded Successfully!")