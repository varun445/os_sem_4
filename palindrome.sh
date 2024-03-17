#!/bin/bash

isPalindrome() {
	local input="$1"
	local reversed=""
	for ((i = ${#input} - 1; i >= 0; i--)); do
		reversed="$reversed${input:$i:1}"
	done
	if [ "$input" == "$reversed" ]; then
		echo "Palindrome"
	else
		echo "Not a palindrome"
	fi
}

read -p "Enter a string: " string
isPalindrome "$string"
