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

int in(Item x, Lista L) {
    if (L == NULL) {
        return 0;
    }
    if (L->item == x) {
        return 1;
    }
    return in(x, L->prox);
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
	int x = 0;
	printf("Informe um numero para verificar se ele pertence a lista: ");
	scanf("%d", &x);
	
	printf("\nLista: ");
    Lista L = no(3, no(1, no(5, no(66, no(6, NULL)))));
    exibe(L);
	
    if (in(x, L)){
    	printf("\n\nO numero %d pertence a Lista.", x);	
	}else{
		printf("\n\nO numero %d nao pertence a Lista.", x);
	}
		
	return 0;
}
