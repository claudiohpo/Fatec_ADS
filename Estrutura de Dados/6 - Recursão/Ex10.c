#include <stdio.h>
#include <stdlib.h>

int prod(int m, int n){
	if (m ==0 || n==0){
		return 0;
	}
	if (m==1){
		return n;
	}
	if (n==1){
		return m;
	}
	return n + prod(m -1, n);
	
}

int main(void){
	int m, n;
	printf("Informe o primeiro numero: ");
	scanf("%d",&m);
	printf("Informe o segundo numero: ");
	scanf("%d",&n);
	printf("O produto dos numeros %d e %d eh: %d",m,n,prod(m,n));
	
	
	return 0;
	
}
