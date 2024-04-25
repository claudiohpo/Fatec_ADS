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

int equal(Lista A, Lista B) {
    if (A == NULL && B == NULL) {
        return 1;
    }
    if (A == NULL || B == NULL) {
        return 0; 
    }
    if (A->item != B->item) {
        return 0; 
    }
    return equal(A->prox, B->prox);
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
	printf("\nLista A: ");
    Lista A = no(1, no(2, no(3, no(4, no(5, NULL)))));
    exibe(A);
    
    printf("\nLista B: ");
    Lista B = no(1, no(2, no(3, no(4, no(5, NULL)))));
    exibe(B);
	
    if (equal(A,B)){
    	printf("\n\nAs listas sao iguais!");
	}else{
		printf("\n\nAs listas nao sao iguais!");
	}
	
	return 0;
}
