#include <stdio.h>
#include <stdlib.h>

int sd(int n){
	if (n<10){
		return n;
	}
	return n % 10 + sd(n/10);
}

int main(void){
	int numero;
	printf("Informe um numero: ");
	scanf("%d",&numero);
	
	printf("A soma dos digitos de %d eh: %d",numero,sd(numero));
	
	return 0;
}
