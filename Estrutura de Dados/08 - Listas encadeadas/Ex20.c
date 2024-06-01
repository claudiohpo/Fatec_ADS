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

Item minimum(Lista L) {
    if (L == NULL) {
        printf("Lista vazia.\n");
    }
    if (L->prox == NULL) {
        return L->item; 
    }
    Item menor = minimum(L->prox);
	return (L->item	< menor) ? L->item : menor; 
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
    Lista L = no(3, no(1, no(5, no(66, no(6, no(0, no(12, NULL)))))));
    exibe(L);
	
    printf("\n\nO menor item da lista eh: %d\n", minimum(L));
    
	return 0;
}
