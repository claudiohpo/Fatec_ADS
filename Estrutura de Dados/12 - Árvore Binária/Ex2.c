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


 void exibe(Arv A,int n) {
    if( A==NULL ) return;
    exibe(A->dir,n+1);
    printf("%*s%d\n",3*n, "" ,A->item);
    exibe(A->esq,n+1);
 }

  int main(void) {
   Arv I = arv(arv(arv(NULL,4,NULL),2,arv(NULL,5,NULL)),1,arv(NULL,3,NULL));
   exibe(I,0);
   return 0;
   }
