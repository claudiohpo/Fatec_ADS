#include <stdio.h>
#include <stdlib.h>

typedef int Item;
typedef struct no {
   Item item;
   struct no *prox;
} *Lista;

Lista no(Item x, Lista p) {
     Lista n = malloc(sizeof(struct no));
     n->item = x;
     n->prox = p;
     return n;
  }

Item nth(int n, Lista L) {
    if (n < 1 || L == NULL) {
        printf("Índice invalido ou lista vazia.\n");
    }
    if (n == 1) {
        return L->item; 
    }
    return nth(n - 1, L->prox); 
}

void exibe(Lista L) {
     printf("[");
     if(L == NULL){
     		
	 }else{
	 	printf("%d",L->item);
        L = L->prox;
		while( L != NULL ) {
	        printf(",%d",L->item);
	        L = L->prox;
	    }	
	 }
	 printf("]");
  }

int main(void) {
	printf("\nLista: ");
    Lista L = no(3, no(1, no(5, no(66, no(6, NULL)))));
    exibe(L);
	
    int n = 0;
    printf("\nInforme qual a posicao do numero que deseja visualizar: ");
    scanf("%d",&n);
    
    printf("\nO %do. item da lista eh: %d\n", n, nth(n, L));
    
	return 0;
}
