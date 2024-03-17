#!/bin/bash

fibo() {
	local number=$1
	local a=0
	local b=1
	local count=0

	while ((count < number)); do
		echo $a
		local temp=$b
		b=$((a + b))
		a=$temp
		((count++))
	done
}

read -p "How many numbers do you want to print? " number

fibo $number
