#!/bin/bash

factorial() {
	if (($1 == 0 || $1 == 1)); then
		echo 1
		return 1
	else
		local result=1
		for ((i = 2; i <= $1; i++)); do
			result=$((result * i))
		done
		echo $result
		return $result
	fi
}

read -p "Enter a number to find its factorial: " number

answer=$(factorial number)
echo "The factorial is $answer"
