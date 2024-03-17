#!/bin/bash

prime() {
	local number=$1
	if ((number <= 1)); then
		echo 0
		return 0
	fi

	for ((i = 2; i <= number / 2; i++)); do
		if ((number % i == 0)); then
			return 1
		fi
	done

	return 0
}

read -p "How many prime numbers do you want to print? " count

echo "The first $count prime numbers are:"

found=0
current_number=2

while ((found < count)); do
	if prime "$current_number"; then
		echo "$current_number"
		((found++))
	fi
	((current_number++))
done
