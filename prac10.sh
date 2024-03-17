#!/bin/bash

# find . -maxdepth 1 \( -type f -executable -o -type d -o -size 0 \) -exec file {} \; | grep -v 'text'

ls -a
