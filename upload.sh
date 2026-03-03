#!/bin/bash

echo "Enter Problem Name:"
read pname

echo "Enter LeetCode Number:"
read pnum

echo "Enter Topic Folder Name (example: 01-Arrays):"
read topic

filename="${pname}_LeetCode_${pnum}.java"

mv solution.java $topic/$filename

git add .
git commit -m "Added $pname (LC-$pnum)"
git push

echo "Uploaded Successfully "