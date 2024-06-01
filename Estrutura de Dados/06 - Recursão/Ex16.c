#include <stdio.h>
#include <stdlib.h>

int h(int n){
	if (n==1){
		return 1;
	}
	return 2 * h(n-1)+1;
}

int main(void){
	int numero;
	printf("Informe o numero de discos: ");
	scanf("%d",&numero);
	
	printf("O numero minimo de movimentos para %d discos eh: %d",numero,h(numero));
	
	return 0;
}
