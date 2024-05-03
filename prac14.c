#include <stdio.h> 

#include <sys/types.h> 

#include <unistd.h> 

int main(){ 

pid_t p; 

p=fork(); 

if(p<0) { 

printf("Error"); } 

else if(p==0) { 

printf("Process id= %d",getpid()); } 

else { 

printf("Process Created= %d",p); } 

return 0; 

} 
