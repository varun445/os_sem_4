#!/bin/bash

findPercentage() {
	local total=$(($1 + $2 + $3))
	local percentage=$((total / 3))

	echo "Total Marks: $total"
	echo "Percentage: $percentage"

	if (($(echo "$percentage >= 80" | bc -l))); then
		echo "Class: Distinction"
	elif (($(echo "$percentage >= 60" | bc -l))); then
		echo "Class: First Division"
	elif (($(echo "$percentage >= 50" | bc -l))); then
		echo "Class: Second Division"
	elif (($(echo "$percentage >= 40" | bc -l))); then
		echo "Class: Third Division"
	else
		echo "Class: Fail"
	fi
}

#Input from user
read -p "Enter marks for subject 1: " subject1
read -p "Enter marks for subject 2: " subject2
read -p "Enter marks for subject 3: " subject3

findPercentage $subject1 $subject2 $subject3
