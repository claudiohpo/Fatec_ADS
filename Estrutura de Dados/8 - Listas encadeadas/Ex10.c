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

int pertence(Item x, Lista L) {
    while (L != NULL) {
        if (L->item == x) {
            return 1;
        }
        L = L->prox;
    }
    return 0;
}

void exibe(Lista L) {
     while( L != NULL ) {
        printf("%d\n", L->item);
        L = L->prox;
     }
}

int main(void) {
   printf("Lista:\n");
   Lista L = no(3, no(1, no(5, no(66, no(6, NULL)))));
   exibe(L);
   
   int x = 66;
   if (x, pertence(x,L)){
   	printf("\nO item %d pertence a lista(L) acima.",x);
   }
   else{
   	printf("\nO item %d nao pertence a lista(L) acima.",x);
   }
   
   return 0;
}

