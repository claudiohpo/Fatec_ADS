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

Arv balanceada(Item *v, int p, int u){
  if(p>u) return NULL;
  int q = (p+u)/2;
  Arv r = arv(balanceada(v,p,q-1), v[q], balanceada(v,q+1,u));
  return r;
}

void preenche_vetor(Arv A, Item *v, int *i) {
    if (A == NULL) return;
    preenche_vetor(A->esq, v, i);
    v[(*i)++] = A->item;
    preenche_vetor(A->dir, v, i);
}


int main(void) {
    srand(time(NULL));
    printf("Arvore aleatoria:\n");
    Arv A = aleatoria(9);
    exibe(A, 0);


    Item v[9];
    int i = 0;
    preenche_vetor(A, v, &i); 

    printf("Arvore balanceada:\n");
    Arv B = balanceada(v, 0, 8);
    exibe(B, 0);
    return 0;
}
