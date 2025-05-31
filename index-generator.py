# index-generator.py

import os
import re

chapter_map = {
    "chapter03_array": "배열",
    "chapter04_string": "문자열",
    "chapter05_recursion": "재귀",
    "chapter06_bruteforce": "완전 탐색",
    "chapter07_sorting": "정렬",
    "chapter08_binarysearch": "이진 탐색",
    "chapter09_hash": "해시",
    "chapter10_dp": "동적 프로그래밍",
    "chapter11_datastructure": "자료 구조",
    "chapter12_implementation": "구현",
}

base_path = "programmers"
index_lines = [
    "| 챕터 | 문제 이름 | 난이도 | 파일명 |",
    "|------|-----------|--------|--------|"
]

for chapter_folder in sorted(os.listdir(base_path)):
    chapter_path = os.path.join(base_path, chapter_folder)
    if not os.path.isdir(chapter_path) or not chapter_folder.startswith("chapter"):
        continue

    chapter_name = chapter_map.get(chapter_folder, "기타")

    for filename in sorted(os.listdir(chapter_path)):
        if filename.endswith(".java"):
            match = re.match(r"Lv(\d+)_(.+)\.java", filename)
            if match:
                level = f"Lv{match.group(1)}"
                problem_name = match.group(2)
                filepath = f"{chapter_folder}/{filename}"
                index_lines.append(f"| {chapter_name} | {problem_name} | {level} | [{filename}]({filepath}) |")

# 저장
with open("programmers/index-table.md", "w", encoding="utf-8") as f:
    f.write("\n".join(index_lines))
