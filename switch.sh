#!/bin/bash

while true; do
	clear
	echo "MENU"
	echo "1) Disply calander of current month"
	echo "2) Disply today's data and time"
	echo "3) Display usernames of those who are currently logged in the system"
	echo "4) Disply your name at given x, y position."
	echo "5) Disply your terminal number."
	echo "6) Exit."

	read -p "Enter your choice: " choice

	case $choice in
	1) cal ;;
	2) date ;;
	3) who ;;
	4)
		read -p "Enter x position: " x
		read -p "Enter y position: " y
		tput cup $y $x
		read -p "Enter your name: " name
		echo "$name"
		;;
	5) tty ;;
	6)
		echo "Exiting..."
		exit 0
		;;
	*)
		echo "Invalid choice. Please enter a number from 1 to 6."
		;;
	esac

	read -p "Press Enter to continue..."
done
