read -p "Enter num1: " num1
read -p "Enter num2: " num2
read -p "Enter num3: " num3

if [[ $num1 -ge $num2 ]]; then
	if [[ $num1 -ge $num3 ]]; then
		gr8r=$num1
	else
		gr8r=$num3
	fi
elif [[ $num1 -le $num2 ]]; then
	if [[ $num2 -ge $num3 ]]; then
		gr8r=$num2
	else
		gr8r=$num3
	fi
fi

echo "gr8r number is $gr8r"
