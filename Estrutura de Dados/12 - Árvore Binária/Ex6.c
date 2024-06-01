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

Arv completa(int altura) {
    if (altura <= 0) return NULL;
    return arv(completa(altura - 1), rand() % 100, completa(altura - 1));
}

void exibe(Arv A, int n) {
    if (A == NULL) return;
    exibe(A->dir, n + 1);
    printf("%*s%d\n", 3 * n, "", A->item);
    exibe(A->esq, n + 1);
}

int nos(Arv A){
    if(A == NULL) return 0;
    return 1 + nos(A->esq) + nos(A->dir);
}


int main(void) {
    srand(time(NULL));
    Arv A = completa(3);
    exibe(A, 0);
    printf("Nos: %d\n\n", nos(A));

    A = arv(arv(arv(NULL,4,NULL),2,arv(NULL,5,NULL)),1,arv(NULL,3,NULL));
    exibe(A,0);
    printf("Nos: %d\n", nos(A));

    return 0;
}
