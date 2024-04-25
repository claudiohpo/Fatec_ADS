#include <stdio.h>
#include <stdlib.h>

typedef int Item;
typedef struct no {
   Item item;
   struct no *prox;
} *Lista;

Lista no(Item x, Lista p) {
     Lista n = malloc(sizeof(struct no));
     n->item = x;
     n->prox = p;
     return n;
  }

int tamanho(Lista L) {
     int t = 0;
     while( L ) {
        t++;
        L = L->prox;
     }
     return t; 
  }

void exibe(Lista L) {
     while( L != NULL ) {
        printf("%d\n",L->item);
        L = L->prox;
     }
  }

int main(void) {
   Lista I = no(3,no(1,no(5,NULL)));
   exibe(I);
   printf("Tamanho = %d\n",tamanho(I));
   return 0;
}

