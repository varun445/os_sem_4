#!/bin/bash

sorted_numbers=$(printf "%s\n" "$@" | sort -nr)

echo "Numbers in descending order:"
echo "$sorted_numbers"
