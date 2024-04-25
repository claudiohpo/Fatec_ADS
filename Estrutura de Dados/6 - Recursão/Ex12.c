#include <stdio.h>
#include <stdlib.h>

int resto(int m, int n){
	if (m<n){
		return m;
	}
	
	if (n==0){
		printf("Divisao por Zero!");
		return n;
	}
	return resto(m -n, n);
}

int main(void){
	int m, n;
	printf("Informe o primeiro numero: ");
	scanf("%d",&m);
	printf("Informe o segundo numero: ");
	scanf("%d",&n);
	printf("O resto da divisao dos numeros %d e %d eh: %d",m,n,resto(m,n));
	
	return 0;
}
