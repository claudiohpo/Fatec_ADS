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

Item maximo(Lista L) {
    if (L == NULL) {
        printf("Erro fatal: a lista esta vazia.\n");
    }

    Item max = L->item;
    while (L != NULL) {
        if (L->item > max) {
            max = L->item;
        }
        L = L->prox;
    }

    return max;
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
   printf("Maior item da lista: %d\n", maximo(L));
   
   return 0;
}

