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

void anexa(Lista *A, Lista B) {
     if( !B ) return;
     while( *A )
        A = &(*A)->prox;
     *A = B;
  }
  
void exibe(Lista L) {
     while( L != NULL ) {
        printf("%d\n",L->item);
        L = L->prox;
     }
  }

int main(void) {
   Lista H = no(4,no(2,NULL));
   Lista I = no(3,no(1,no(5,NULL)));
   printf("H = "); exibe(H);
   printf("I = "); exibe(I);
   printf("Pressione enter");
   getchar();
   anexa(&H,I);
   printf("H = "); exibe(H);
   printf("I = "); exibe(I);
   return 0;
}

