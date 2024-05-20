#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int Chave;
typedef char Valor[22];
typedef struct map {
   Chave chave;
   Valor valor;
   struct map *prox;
} *Map;

Map no_map(Chave c, Valor v, Map p) {
     Map n = malloc(sizeof(struct map));
     n->chave = c;
     strcpy(n->valor,v);
     n->prox = p;
     return n;
  }
  
 void insm(Chave c, Valor v, Map *M) {
     while( *M && c>(*M)->chave ) 
        M = &(*M)->prox;
     if( *M && c==(*M)->chave )
        strcpy((*M)->valor,v);
     else *M = no_map(c,v,*M);
  }

void remmr(Chave c, Map *M) {
    if (*M == NULL) {
        return; 
    }
    if (c < (*M)->chave) {
        return; 
    }
    if (c == (*M)->chave) {
        Map n = *M;
        *M = n->prox;
        free(n);
        return; 
    }
    remmr(c, &(*M)->prox);
}

void exibem(Map M) {
     printf("[");
     while( M ) {
        printf("(%d,%s)",M->chave,M->valor);
        if( M->prox ) printf(",");
        M = M->prox;
     }
     printf("]\n");
  }

int main(void) {
   Map I = NULL;
   insm(36,"Leo",&I); insm(15,"Ivo",&I); 
   insm(42,"Eva",&I); insm(29,"Ana",&I);
   exibem(I);
   remmr(29,&I);
   exibem(I);   
   remmr(42,&I);
   exibem(I);      
   return 0;
}


