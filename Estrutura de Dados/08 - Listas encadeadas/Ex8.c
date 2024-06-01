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

Item ultimo(Lista L) {
    if (L == NULL) {
        printf("Erro fatal: a lista esta vazia.\n");
    }

    while (L->prox != NULL) {
        L = L->prox;
    }

    return L->item;
}

void exibe(Lista L) {
     while( L != NULL ) {
        printf("%d\n", L->item);
        L = L->prox;
     }
}

int main(void) {
   Lista L = no(3, no(1, no(5, no(66, no(6, NULL)))));
   exibe(L);
   printf("Ultimo item da lista: %d\n", ultimo(L));
   
   return 0;
}

