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

int clone(Lista L) {
    if (L == NULL) {
        return 0; 
    } else {
        return no(L->item, clone(L->prox));
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
	Lista L =no(3,no(1,no(5,NULL)));
	Lista clonada = clone(L);
	
	printf("Lista original: ");
    exibe(L);
    printf("\n\nCopia da lista: ");
    exibe(clonada);
	
	return 0;
}
