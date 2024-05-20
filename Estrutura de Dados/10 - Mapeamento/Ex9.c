#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int Chave;
typedef int Valor;

typedef struct map {
  Chave chave;
  Valor valor;
  struct map *prox;
} *Map;

Map no_map(Chave c, Valor v, Map p) {
  Map n = malloc(sizeof(struct map));
  n->chave = c;
  n->valor=v;
  n->prox = p;
  return n;
} 

void insm(Chave c, Valor v, Map *M) {
  while( *M && c>(*M)->chave )
    M = &(*M)->prox;
  if( *M && c==(*M)->chave )
    (*M)->valor=v;
  else *M = no_map(c,v,*M);
}

void exibem(Map M) {
  printf("[");
  while( M ) {
    printf("(%d,%d)",M->chave,M->valor);
    if( M->prox ) printf(",");
      M = M->prox;
  }
  printf("]\n");
}


int main(void) {
  Map I = NULL;
  int tamanho, num_chave;
  Valor valor;

  printf("Digite o a quantidade de chaves que o mapeamento tera (Somente Numeros): ");
  scanf("%d", &tamanho);

  for(int i = 1; i <= tamanho; i++){
    
	printf("Digite a %da. chave:\n", i);
    scanf("%d", &num_chave);
    
    printf("Digite o valor referente ao %do. valor:\n", i);
    scanf("%d", &valor);
    insm(num_chave, valor, &I);
   
  }
  exibem(I);
}



