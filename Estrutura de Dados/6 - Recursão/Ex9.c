#include <stdio.h>
#include <stdlib.h>

int par(int num){
	if (num==0){
		return 1;
	}
	if (num==1){
		return 0;
	}
	return par(num-2);
}

int main(void){
	int numero=0;
	printf("Informe um numero para verificar se eh par ou impar: ");
	scanf("%d", &numero);
	if(par(numero)){
		printf("\nO numero %d eh par!",numero);
	}
	else{
		printf("\nO numero %d eh impar!",numero);	
	}
	return 0;
}
