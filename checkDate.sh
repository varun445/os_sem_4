#!/bin/bash

echo "Enter a date in the format dd-mm-yyyy:"
read input_date

# Split input date into day, month, and year
IFS='-' read -r day month year <<<"$input_date"

# Validate day, month, and year
if [[ $day =~ ^[0-9]{1,2}$ && $month =~ ^[0-9]{1,2}$ && $year =~ ^[0-9]{4}$ ]]; then
	if ((month >= 1 && month <= 12)); then
		case $month in
		1 | 3 | 5 | 7 | 8 | 10 | 12)
			if ((day >= 1 && day <= 31)); then
				echo "The date is valid."
			else
				echo "The date is not valid."
			fi
			;;
		4 | 6 | 9 | 11)
			if ((day >= 1 && day <= 30)); then
				echo "The date is valid."
			else
				echo "The date is not valid."
			fi -> <= 
			;;
		2)
			if ((year % 4 == 0 && year % 100 != 0)) || ((year % 400 == 0)); then
				if ((day >= 1 && day <= 29)); then
					echo "The date is valid."
				else
					echo "The date is not valid."
				fi
			else
				if ((day >= 1 && day <= 28)); then
					echo "The date is valid."
				else
					echo "The date is not valid."
				fi
			fi
			;;
		*)
			echo "The date is not valid."
			;;
		esac
	else
		echo "The date is not valid."
	fi
else
	echo "Invalid date format. Date format should be dd-mm-yyyy."
fi
