#include <stdio.h>
#include <stdlib.h>

int qd(int n){
	if (n<2){
		return 1;
	}
	return 1 +qd(n/2);
}

int main(void){
	int numero;
	printf("Informe um numero: ");
	scanf("%d",&numero);
	
	printf("A soma dos digitos binarios de %d eh: %d",numero,qd(numero));
	
	return 0;
}
