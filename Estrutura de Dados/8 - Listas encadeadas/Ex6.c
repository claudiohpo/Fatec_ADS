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
  
Lista intervalo(int n) {
    Lista L = NULL;
    for (int i = n; i >= 1; i--) {
        L = no(i, L);
    }
    return L;
}


int main(void) {
   int num;
   printf("Intervalo de 1 a (n). Informe o numero final do intervalo:");
   scanf("%d", &num);
   Lista B = intervalo(num);
   exibe(B);
   
    return 0;
}
