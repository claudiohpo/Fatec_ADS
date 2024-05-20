#include <stdio.h>
#include <stdlib.h>

typedef int Item;
typedef struct no {
   Item item;
   struct no *prox;
} *Lista;

void exibe(Lista L) {
     while( L != NULL ) {
        printf("%d\n",L->item);
        L = L->prox;
     }
  }
  
Lista no(Item x, Lista p) {
     Lista n = malloc(sizeof(struct no));
     n->item = x;
     n->prox = p;
     return n;
  }

void ins(Item x, Lista *L) {
     while( *L != NULL && (*L)->item < x ) 
        L = &(*L)->prox;
     *L = no(x,*L);
  }
  
void rem(Item x, Lista *L) {
     while( *L != NULL && (*L)->item < x ) 
        L = &(*L)->prox;
     if( *L == NULL || (*L)->item > x ) return;
     Lista n = *L;
     *L = n->prox;
     free(n);
  }
  
void rem_todo(Item x, Lista *L) {
    while (*L != NULL) {
        if ((*L)->item < x) {
            L = &(*L)->prox;
        } else if ((*L)->item == x) {
            Lista n = *L;
            *L = n->prox;
            free(n);
        } else {
            break;
        }
    }
}

int pert(Item x, Lista L) {
     while( L != NULL && L->item < x ) 
        L = L->prox;
     return (L != NULL && L->item == x);
  }


int main(void) {
   Lista I = NULL;
   ins(4,&I); 
   ins(1,&I); 
   ins(3,&I); 
   ins(2,&I);
   printf("%d\n", pert(5,I));
   printf("%d\n", pert(3,I));
   return 0;
}



