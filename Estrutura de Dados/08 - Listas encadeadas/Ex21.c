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

int sorted(Lista L) {
    if (L == NULL || L->prox == NULL) {
        return 1;
    }
    if (L->item > L->prox->item) {
        return 0; 
    }
    return sorted(L->prox); 
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
	
    if (sorted(L)){
    	printf("\n\nA lista esta ordenada!");
	}else{
		printf("\n\nA lista nao esta ordenada!");
	}
	
	return 0;
}
