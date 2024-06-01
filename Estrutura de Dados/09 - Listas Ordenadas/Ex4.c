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

void ins_rsr(Item x, Lista *L) {
    if (*L == NULL || (*L)->item > x) {
        *L = no(x, *L); 
    } else if ((*L)->item < x) {
        ins_rsr(x, &(*L)->prox);
    }
}

int main(void) {
    Lista I = NULL;
    ins(4, &I);
    ins(1, &I);
    ins(3, &I);
    ins(5, &I);
    ins(2, &I);
    exibe(I);
    
    printf("\n");

    ins_rsr(3, &I); 
    ins_rsr(6, &I); 
    ins_rsr(1, &I); 
    exibe(I);
    
    return 0;
}

