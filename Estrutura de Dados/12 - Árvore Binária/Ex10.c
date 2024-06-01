#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef int Item;

typedef struct arv {
    struct arv *esq;
    Item item;
    struct arv *dir;
} *Arv;

Arv arv(Arv e, Item x, Arv d) {
    Arv n = malloc(sizeof(struct arv));
    n->esq = e;
    n->item = x;
    n->dir = d;
    return n;
}

Arv aleatoria(int n) {
    if (n <= 0) return NULL;
    return arv(aleatoria(n / 2), rand() % 100, aleatoria(n - n / 2 - 1));
}

void exibe(Arv A, int n) {
    if (A == NULL) return;
    exibe(A->dir, n + 1);
    printf("%*s%d\n", 3 * n, "", A->item);
    exibe(A->esq, n + 1);
}



Arv clone(Arv A) {
    if (A == NULL) return NULL; 
    Arv novo = malloc(sizeof(struct arv));
    novo->item = A->item;
    novo->esq = clone(A->esq); 
    novo->dir = clone(A->dir); 

    return novo; 
}


int main(void) {
    srand(time(NULL));
    Arv A= aleatoria(9);
    exibe(A, 0);

    printf("Clone da Arvore exibida:");

    Arv B = clone(A);
    exibe(B, 0);
    return 0;
}
