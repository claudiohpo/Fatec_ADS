#include <stdio.h>
#include <stdlib.h>

void cr(int n) {
	if(n==0)return;
	printf("%d\n",n);
	cr(n-1);
}

int main(void) {
	int n;
	printf("Num? ");
	scanf("%d",&n);
	cr(n);
	return 0;
}
