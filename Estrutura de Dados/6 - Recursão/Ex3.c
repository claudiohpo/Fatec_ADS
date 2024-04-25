#include <stdio.h>
#include <stdlib.h>

int termial(int n) {
	if(n==0)return 0;
	return termial(n-1) +n;
}

int main(void) {
	int n;
	printf("Num? ");
	scanf("%d",&n);
	printf("Termial= %d\n",termial(n));
	return 0;
}
