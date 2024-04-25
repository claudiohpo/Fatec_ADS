#include<stdio.h>

int main(void){
	int p;
	printf("Placa? ");
	scanf("%d",&p);
	switch(p%10){
		case 1: case 2: puts("Segunda-feira"); break;
		case 3: case 4: puts("Terca-feira"); break;
		case 5: case 6: puts("Quarta-feira"); break;
		case 7: case 8: puts("Quinta-feira"); break;
		default:	  puts("Sexta-feira");
	}
	return 0;
}

