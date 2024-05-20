#include <stdio.h>
#include <stdlib.h>

typedef int Item;
typedef struct no {
    Item item;
    struct no *prox;
} *Lista;

void exibe(Lista L) {
    while (L != NULL) {
        printf("%d\n", L->item);
        L = L->prox;
    }
}

Lista no(Item x, Lista p) {
    Lista n = malloc(sizeof(struct no));
    n->item = x;
    n->prox = p;
    return n;
}

void ins(Item x, Lista *L) {
    while (*L != NULL && (*L)->item < x)
        L = &(*L)->prox;
    *L = no(x, *L);
}

int osc(Lista L) {
    if (L == NULL || L->prox == NULL) {
        return 1; 
    }
    if (L->item > L->prox->item) {
        return 0; 
    }
    return osc(L->prox); 
}

int main(void) {
    Lista I = NULL;
    ins(1, &I);
    ins(2, &I);
    ins(3, &I);
    ins(4, &I);

    printf("Lista antes de verificar se está ordenada:\n");
    exibe(I);

    printf("A lista está ordenada de forma crescente? %d\n", osc(I));

    ins(3, &I); 

    printf("\nLista depois de inserir um valor fora de ordem:\n");
    exibe(I);

    printf("A lista está ordenada de forma crescente? %d\n", osc(I));

    return 0;
}

