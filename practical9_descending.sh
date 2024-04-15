#!/bin/bash

read -p "enter the number of elements you want:" N 
echo "enter $N elements of array :" 
for ((i=0;i<$N; i++)) 
do 
        read a[$i] 
        done 
for ((j=0;j<$N;j++)) 
do 
        for ((k=0;k<$N;k++)) 
        do 
        if [[ ${a[j]}>${a[k]} ]] 
        then 
                t=${a[j]} 
                a[j]=${a[k]} 
                a[k]=$t 
                fi 
        done 
done 

echo "array-${a[*]}" 
