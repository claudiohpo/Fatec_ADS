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

typedef struct dic {
   int tam;
   Map *vet;
} *Dic;

Map no_map(Chave c, Valor v, Map p) {
     Map n = malloc(sizeof(struct map));
     n->chave = c;
     strcpy(n->valor,v);
     n->prox = p;
     return n;
  }
  
Dic dic(int m) {
   Dic d = malloc(sizeof(struct dic));
   d->tam = m;
   d->vet = malloc(m*sizeof(Map));
   for(int i=0; i<m; i++) d->vet[i] = NULL;
   return d;
}

void insm(Chave c, Valor v, Map *M) {
     while( *M && c>(*M)->chave ) 
        M = &(*M)->prox;
     if( *M && c==(*M)->chave )
        strcpy((*M)->valor,v);
     else *M = no_map(c,v,*M);
  }

void remm(Chave c, Map *M) {
   while( *M && c>(*M)->chave ) 
      M = &(*M)->prox;
   if( *M==NULL || c!=(*M)->chave ) return;
   Map n = *M;
   *M = n->prox;
   free(n);
}

int pertm(Chave c, Valor v, Map M) {
   while( M && c>M->chave ) 
      M = M->prox;
   if( M && c==M->chave ) 
      strcpy(v,M->valor);
   return (M && c==M->chave);
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

int hash(int c, int m) {
   return (c % m);
}

void insd(Chave c, Valor v, Dic d) {
   insm(c, v, &d->vet[hash(c,d->tam)]);
}

void remd(Chave c, Dic d) {
   remm(c, &d->vet[hash(c,d->tam)]);
}

int pertd(Chave c, Valor v, Dic d) {
   return pertm(c, v, d->vet[hash(c,d->tam)]);
}

void exibed(Dic d) {
   for(int i=0; i<d->tam; i++) {
      printf("%d: ", i);
      exibem(d->vet[i]);
   }
}

void destroim(Map *M) {
    while (*M) {
        Map temp = *M;
        *M = (*M)->prox;
        free(temp);
    }
}

void destroid(Dic *d) {
   for(int i=0; i<(*d)->tam; i++)
      destroim(&(*d)->vet[i]);
   free(*d);
   *d = NULL;
}

int main(void) {
   Dic D = dic(5);
   insd(59, "Bia", D);
   insd(48, "Eva", D);
   insd(25, "Ivo", D);
   insd(17, "Ana", D);
   insd(83, "Leo", D);
   printf("Dicionario com valores incluidos:\n");
   exibed(D);
   
   remd(48, D);
   remd(25, D);
   remd(17, D);
   printf("\n\nDicionario com valores removido:\n");
   exibed(D);
   return 0;
}

