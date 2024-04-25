#include <stdio.h>
#include <stdlib.h>

void binario(int n) {
	if(n<2)printf("%d",n);
	else{
		binario(n/2);
		printf("%d",n%2);
	}
}

int main(void) {
	int n;
	printf("Num? ");
	scanf("%d",&n);
	binario(n);
	return 0;
}
