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

int iguais(Arv A, Arv B) {
    
    if (A == NULL && B == NULL)
        return 1;
    else if (A == NULL || B == NULL)
        return 0;
    else if (A->item != B->item)
        return 0;
    else
        return iguais(A->esq, B->esq) && iguais(A->dir, B->dir);
}



int main(void) {
  srand(time(NULL));
  Arv A= aleatoria(9);
  Arv B= aleatoria(9);
  exibe(A, 0);
  printf("\n\n");
  exibe(B, 0);
  if(!iguais(B,A)){
    printf("\n\nAs arvores sao diferentes");
  } else{
    printf("\n\nAs arvores sao iguais");
  }
    
  return 0;
}
