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

int main() {
    // Caso 1
    Arv A1 = NULL;
    ins(4, &A1);
    printf("Caso 1 - Arvore original:\n");
    exibe(A1, 0);
    remraiz(&A1);
    printf("Caso 1 - Arvore apos remocao da raiz:\n");
    exibe(A1, 0);

    // Caso 2
    Arv A2 = NULL;
    ins(4, &A2);
    ins(1, &A2);
    ins(3, &A2);
    ins(0, &A2);
    ins(2, &A2);
    printf("\n\nCaso 2 - Arvore original:\n");
    exibe(A2, 0);
    remraiz(&A2);
    printf("Caso 2 - Arvore apos remocao da raiz:\n");
    exibe(A2, 0);

    // Caso 3
    Arv A3 = NULL;
    ins(4, &A3);
    ins(6, &A3);
    ins(5, &A3);
    ins(7, &A3);
    printf("\n\nCaso 3 - Arvore original:\n");
    exibe(A3, 0);
    remraiz(&A3);
    printf("Caso 3 - Arvore apos remocao da raiz:\n");
    exibe(A3, 0);

    // Caso 4
    Arv A4 = NULL;
    ins(4, &A4);
    ins(1, &A4);
    ins(6, &A4);
    ins(0, &A4);
    ins(3, &A4);
    ins(5, &A4);
    ins(7, &A4);
    ins(2, &A4);
    printf("\n\nCaso 4 - Arvore original:\n");
    exibe(A4, 0);
    remraiz(&A4);
    printf("Caso 4 - Arvore apos remocao da raiz:\n");
    exibe(A4, 0);
    
    return 0;
}




