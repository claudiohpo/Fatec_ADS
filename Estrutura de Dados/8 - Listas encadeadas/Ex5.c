#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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

Lista aleatoria(int n, int m) {
     Lista L = NULL;
     while( n>0 ) {
        L = no(rand()%m, L);
        n--;
     }
     return L;
  }

void exibe(Lista L) {
     while( L != NULL ) {
        printf("%d\n",L->item);
        L = L->prox;
     }
  }

int main(void) {
   srand(time(NULL));
   Lista A = aleatoria(10,100);
   exibe(A);
   return 0;
}

