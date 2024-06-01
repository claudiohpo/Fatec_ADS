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

Item last(Lista L) {
    if (L == NULL) {
        printf("Erro: a lista esta vazia.\n");
    }
    if (L->prox == NULL) {
        return L->item; 
    }
    return last(L->prox);
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
	printf("Lista: ");
    Lista L = no(3, no(1, no(5, no(66, no(6, NULL)))));
    exibe(L);
	
    Lista ultimo = last(L);
    printf("\n\nO ultimo item da Lista eh: %d", ultimo);
    
	
	return 0;
}
