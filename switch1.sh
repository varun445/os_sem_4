#!/bin/bash

while true; do
	clear
	echo "Menu"
	echo "1) Addition"
	echo "2) Substraction"
	echo "3) Multiplication"
	echo "4) Division"
	echo "5) Exit"

	read -p "Enter your choice: " choice

	if [[ choice -eq 5 ]]; then
		exit 0
	fi

	read -p "Enter first number: " num1
	read -p "Enter second number: " num2

	case $choice in
	1)
		result=$((num1 + num2))
		echo "$result"
		;;
	2)
		result=$((num1 - num2))
		echo "$result"
		;;
	3)
		result=$((num1 * num2))
		echo "$result"
		;;
	4)
		result=$((num1 / num2))
		echo "$result"
		;;
	5)
		echo "Exiting..."
		exit 0
		;;
	*)
		echo "Invalid choice. Please enter a number from 1 to 5."
		;;
	esac

	read -p "Press Enter to continue..."
done
