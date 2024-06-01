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

int emordem(Arv A){
    if(A == NULL) return 0;
    emordem(A->esq);
    printf("%d ", A->item);
    emordem(A->dir);

}

int main(void) {
    int x;
    srand(time(NULL));
    Arv A= aleatoria(9);
    exibe(A, 0);
    printf("A sequencia em-ordem da arvore exibida eh: ");
    emordem(A);



  return 0;
}
