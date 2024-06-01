#include <stdio.h>
#include <stdlib.h>

typedef int Item;
typedef struct arv {
   struct arv *esq;
   Item item;
   struct arv *dir;
} *Arv;

Arv arv(Arv e, Item x, Arv d) {
     Arv n = malloc(sizeof(struct arv));
     n->esq  = e;
     n->item = x;
     n->dir  = d;
     return n;
  }

void ins(Item x, Arv *A) {
     if( *A == NULL ) *A = arv(NULL,x,NULL);
     else if( x <= (*A)->item ) ins(x,&(*A)->esq);
     else ins(x,&(*A)->dir);
  }

int busca(Item x, Arv A) {
     if( A == NULL ) return 0;
     if( x == A->item ) return 1;
     if( x < A->item ) return busca(x,A->esq);
     else return busca(x,A->dir);
  }

void rem(Item x, Arv *A) {
   if( *A == NULL ) return;
   if( x == (*A)->item ) remraiz(A);
   else if( x < (*A)->item ) rem(x,&(*A)->esq);
   else rem(x,&(*A)->dir);
}

Item remmax(Arv *A) {
     if( *A == NULL ) abort();
     if( (*A)->dir == NULL ) {
        Arv n = *A;
        Item x = n->item;
        *A = n->esq;
        free(n);
        return x;
     }
     return remmax(&(*A)->dir);
  }

void remraiz(Arv *A) {
   if( *A == NULL ) abort();
   Arv n = *A;
   if( n->esq == NULL ) *A = n->dir;
   else if( n->dir == NULL ) *A = n->esq;
   else n->item = remmax(&n->esq);
   if( n != *A ) free(n);
}

int emordem(Arv A){
    if(A == NULL) return 0;
    emordem(A->esq);
    printf("%d ", A->item);
    emordem(A->dir);
}

void exibe(Arv A,int n) {
   if( A==NULL ) return;
   exibe(A->dir,n+1);
   printf("%*s%d\n",3*n,"",A->item);
   exibe(A->esq,n+1);
}

Item minimo(Arv A) {
    if (A == NULL) {
        printf("A arvore esta vazia.\n");
        exit(EXIT_FAILURE);
    }
    if (A->esq == NULL) {
        return A->item;
    }
    return minimo(A->esq);
}

int main() {
    Arv A = NULL;
    ins(5, &A);
    ins(3, &A);
    ins(7, &A);
    ins(2, &A);
    ins(4, &A);
    ins(6, &A);
    ins(8, &A);

    printf("Arvore em ordem decrescente:\n");
    exibe(A, 0);
    printf("\n");

    Item min = minimo(A);
    printf("O maior item da arvore eh: %d\n", min);

    return 0;
}

