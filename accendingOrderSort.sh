#!/bin/bash

sorted_numbers=$(printf "%s\n" "$@" | sort -n)

echo "Numbers in accending order:"
echo "$sorted_numbers"
