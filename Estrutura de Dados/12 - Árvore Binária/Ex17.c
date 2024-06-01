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

Arv poda(Arv *A){
  if(*A == NULL) return NULL;
  if((*A)->esq == NULL && (*A)->dir == NULL){
    Arv temp = *A;
    *A = NULL;
    free(temp);
    return NULL;
  }
  (*A)->esq = poda(&(*A)->esq);
  (*A)->dir = poda(&(*A)->dir);
  return *A;
}

int main(void) {
  Arv *B;
    srand(time(NULL));
    Arv A= aleatoria(9);
    exibe(A, 0);
    printf("A arvore exibida sem suas folhas eh: \n\n");
    B= poda(&A);
    exibe(A,0);
  return 0;
}
