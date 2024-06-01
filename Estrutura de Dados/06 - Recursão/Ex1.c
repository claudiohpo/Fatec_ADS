#include <stdio.h>
#include <stdlib.h>

int fat(int n) {
	if(n==0) return 1; 
	return n*fat(n-1);
}

int main(int argc, char *argv[]) {
	int n=0;
	printf("Num? ");
	scanf("%d", &n);
	
	printf("Fat = %d\n", fat(n));
	
	return 0;
}
