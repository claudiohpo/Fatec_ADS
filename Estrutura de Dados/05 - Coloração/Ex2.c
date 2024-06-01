#include <stdio.h>
#include <conio.h>
#define dim 9
#include "fila.h"
#define cor(i,j) (i>=0 && i<dim && j>=0 && j<dim ? I[i][j] : -1)
#define par(i,j) ((i)*100+(j))
#define lin(p) ((p)/100)
#define col(p) ((p)%100)


void inicia(int I[dim][dim], char *s) {
	FILE *a = fopen(s,"r");
	if( !a ) {
		puts("arquivo não encontrado");
		abort();
	}
	for(int i=0; i<dim; i++)
		for(int j=0; j<dim; j++)
			fscanf(a,"%d",&I[i][j]);
	fclose(a);
}

void colorir(int I[dim][dim], int i, int j, int n) {
	Fila F = fila(dim*dim);
	int a = I[i][j];
	I[i][j] = n;
	enfileira(par(i,j),F);
	while( !vaziaf(F) ) {
		int p = desenfileira(F);
		i = lin(p);
		j = col(p);
		
		
		if( cor(i-1,j)==a ) { I[i-1][j]=n; enfileira(par(i-1,j),F); }
		if( cor(i,j+1)==a ) { I[i][j+1]=n; enfileira(par(i,j+1),F); }
		if( cor(i+1,j)==a ) { I[i+1][j]=n; enfileira(par(i+1,j),F); }
		if( cor(i,j-1)==a ) { I[i][j-1]=n; enfileira(par(i,j-1),F); }
		if( cor(i,j)==a) 	{ I[i][j]=n; printf("mesma cor!\n"); break;}
	}
	destroif(&F);
}

void exiba(int I[dim][dim]) {
	for(int i=-1; i<dim; i++) {
		_textcolor(8);
		for(int j=-1; j<dim; j++)
			if( i<0 && j<0 ) printf(" ");
			else if( i<0 ) printf("%2d",j);
			else if( j<0 ) printf("\n%2d",i);
			else {
				_textcolor(I[i][j]);
				printf("%c%c",219,219);
			}
	}
	_textcolor(8);
}

int main(void) {
	int I[dim][dim];
    int i, j, n;
    inicia(I,"imagem.txt");
	while( 1 ) {
		exiba(I);
		printf("\n\nNova cor (ou -1 para sair)? ");
		scanf("%d",&n);
		if( n<0 ) break;
		do {
			printf("Posicao? ");
			scanf("%d,%d",&i,&j);
		} while( i<0 || i>=dim || j<0 || j>=dim );
		colorir(I,i,j,n);
	}
	return 0;
}
