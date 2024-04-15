sum() { 
echo "Sum = $1" 
} 
echo "Enter two numbers:" 
read a b 
s=$[a+b] 
sum $s 
