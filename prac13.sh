#!/bin/bash

read -p 'Enter your Name: ' str 
echo 'Your name in capital:' "$str" | awk -v str="$str" '{print toupper(str)}'
echo 'Your name in lowercase:' "$str" | awk -v str="$str" '{print tolower(str)}'

