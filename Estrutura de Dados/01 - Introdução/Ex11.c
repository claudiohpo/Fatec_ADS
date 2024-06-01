#include <stdio.h>

int main(void) {
	int v =5; // variável simples
	int*p; // variável ponteiro
	p = &v;
	*p =*p +2;
	printf("v=%d, *p=%d\n",v,*p);
	
	return 0;
}
