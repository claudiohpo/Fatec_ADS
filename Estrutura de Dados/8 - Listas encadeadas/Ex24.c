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

Lista replace(Item x, Item y, Lista L) {
    if (L == NULL) {
        return NULL;
    }
    if (L->item == x) {
        L->item = y;
    }
    L->prox = replace(x, y, L->prox);
    return L;
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
	printf("\nLista Original: ");
    Lista L = no(3, no(1, no(5, no(1, no(6, no(0, no(1, NULL)))))));
    exibe(L);
    
    int num = 0;
    printf("\n\nInforme qual numero da lista quer substituir: ");
    scanf("%d",&num);
    
    int substituto = 0;
    printf("\nInforme o numero que substituira o numero %d: ",num);
    scanf("%d",&substituto);
    
	L = replace(num, substituto, L);
    
    printf("\n\nLista Modificada: ");
    exibe(L);
    
		
	return 0;
}
