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

void ins_rec(Item x, Lista *L) {
    if (*L == NULL || (*L)->item < x) {
        *L = no(x, *L); 
    } else {
        ins_rec(x, &(*L)->prox); 
    }
}

void exibe(Lista L) {
    while (L != NULL) {
        printf("%d\n", L->item);
        L = L->prox;
    }
}

int main(void) {
    Lista I = NULL;
    ins_rec(4, &I);
    ins_rec(1, &I);
    ins_rec(3, &I);
    ins_rec(5, &I);
    ins_rec(2, &I);

    exibe(I);
    
    return 0;
}

