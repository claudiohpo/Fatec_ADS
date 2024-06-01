#include <stdio.h>
#include <stdlib.h>

void cp(int n) {
	if(n==0)return;
	cp(n-1);
	printf("%d\n",n);
}

int main(void) {
	int n;
	printf("Num? ");
	scanf("%d",&n);
	cp(n);
	return 0;
}
