#include <stdio.h>
#include <stdlib.h>


float pot(float x,int n) {
	if(n==0)return 1;
	return x*pot(x,n-1);
}

int main(void) {
	float x;
	int n;
	printf("Base e expoente? ");
	scanf("%f %d",&x,&n);
	printf("Pot = %.1f\n",pot(x,n));
	return 0;
}
