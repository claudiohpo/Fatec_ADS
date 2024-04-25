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

int len(Lista L) {
    if (L == NULL) {
        return 0; 
    } else {
        return 1 + len(L->prox);
    }
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
	Lista L =no(3,no(1,no(5,NULL)));
	exibe (L);
	printf("\nTamanho da lista eh: %d", len(L));
	
	return 0;
}
