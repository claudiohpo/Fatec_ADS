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

Arv espelho(Arv A){
  if(A == NULL) return NULL;
  return arv(espelho(A->dir), A->item, espelho(A->esq));

}

int espelho_ou_nao(Arv A, Arv B){
  if(A == NULL && B == NULL) return 1;
  if(A == NULL || B == NULL) return 0;
  if(A->item != B->item) return 0;
  return espelho_ou_nao(A->esq, B->dir) && espelho_ou_nao(A->dir, B->esq);
}


int main(void) {
    srand(time(NULL));
  printf("Árvore A:\n");
    Arv A= aleatoria(9);
    exibe(A, 0);
  printf("Árvore B:\n");
    Arv B = espelho(A);
    exibe(B, 0);
  
  if(espelho_ou_nao(A, B)){
    printf("As Arvores sao espelhos.\n");
  }else{
    printf("As Arrvores nao sao espelhos.\n");
  }
  
    return 0;
}
