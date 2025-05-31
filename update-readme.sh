#!/bin/bash

README="programmers/README.md"
INDEX_TABLE="programmers/index-table.md"

# 인덱스 생성
python3 index-generator.py

# README.md 갱신
awk '
  BEGIN {found=0}
  /^## ✅ 인덱스/ {print; while (getline) { if ($0 ~ /^## / && $0 != "## ✅ 인덱스") {print $0; found=1; break} }; next}
  found == 0 {print}
' "$README" > programmers/temp-readme.md

echo -e "\n" >> programmers/temp-readme.md
cat "$INDEX_TABLE" >> programmers/temp-readme.md

mv programmers/temp-readme.md "$README"
