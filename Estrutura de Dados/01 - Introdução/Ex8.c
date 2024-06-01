#include<stdio.h>

void barras(int v[],int n){
	for(int i=0; i<n; i++){
		for(int j=0; j<v[i]; j++)
			putchar(220);
		putchar('\n');
	}
}

int main(void){
	int a[4] = {3,4,2,1};
	int b[3] = {9,4,7};
	barras (a,4);
	getchar();
	barras (b,3);
	
	return 0;
}

