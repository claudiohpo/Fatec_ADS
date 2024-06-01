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

Lista inversa(Lista L) {
    Lista invertida = NULL;
    while (L != NULL) {
        invertida = no(L->item, invertida);
        L = L->prox;
    }
    return invertida;
}


void exibe(Lista L) {
     printf("[");
	 while( L != NULL ) {
        printf("%d", L->item);
        if (L->prox != NULL) {
            printf(",");
        }
        L = L->prox;
     }
     printf("]");
}

int main(void) {
   printf("Lista:\n");
   Lista L = no(3, no(1, no(5, no(66, no(6, NULL)))));
   exibe(L);
   
   Lista L_invertida = inversa(L);
   printf("\n\nLista invertida: \n");
   exibe(L_invertida);
   
   return 0;
}

