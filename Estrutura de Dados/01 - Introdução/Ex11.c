#include <stdio.h>

int main(void) {
	int v =5; // vari�vel simples
	int*p; // vari�vel ponteiro
	p = &v;
	*p =*p +2;
	printf("v=%d, *p=%d\n",v,*p);
	
	return 0;
}
