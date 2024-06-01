#include <stdio.h>
#include <stdlib.h>

int quoc(int m, int n){
	if (m<n){
		return 0;
	}
	if (n==1){
		return m;
	}
	if (n==0){
		printf("Divisao por Zero!");
		return n;
	}
	return 1 + quoc(m -n, n);
}

int main(void){
	int m, n;
	printf("Informe o primeiro numero: ");
	scanf("%d",&m);
	printf("Informe o segundo numero: ");
	scanf("%d",&n);
	printf("O quociente dos numeros %d e %d eh: %d",m,n,quoc(m,n));
	
	return 0;
}
