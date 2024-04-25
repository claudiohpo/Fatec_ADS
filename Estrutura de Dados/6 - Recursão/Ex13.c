#include <stdio.h>
#include <stdlib.h>

int q(int n){
	if (n==1){
		return 1;
	}
	return (2*n-1) + q(n-1);
}

int main(void){
	int numero;
	printf("Informe um numero: ");
	scanf("%d",&numero);
	
	printf("O quadrado de %d eh: %d",numero,q(numero));
	
	return 0;
}
