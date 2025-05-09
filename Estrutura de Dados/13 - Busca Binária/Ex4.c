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

int main(void) {
   int v[9] = {71,43,64,92,80,27,58,35,16};
   Arv A = NULL;
   for(int i=0; i<9; i++) ins(v[i],&A);
   emordem(A);
   puts("\nPara sair, digite um inteiro negativo!");
   while( 1 ) {
      int x;
      printf("\nItem a ser buscado? ");
      scanf("%d",&x);
      if( x<0 ) break;
      if( busca(x,A) ) puts("Encontrado!");
      else puts("Inexistente!"); 
   }
   return 0;
}



