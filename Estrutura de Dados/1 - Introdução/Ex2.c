#include<stdio.h>
#include<math.h>

int main(void){
	float p,a,i;
	
	printf("Peso e altura?");
	scanf("%f %f",&p,&a);
	i = p/pow(a,2);
	
	printf("IMC = %.2f\n",i);
	
	if(i<18.5) puts("Magra");
	else if(i>30) puts("Obesa");
	else puts("Normal");
	
	return 0;
}

