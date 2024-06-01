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

Lista rnd(int n, int m) {
    Lista lista = NULL; 
    srand(time(NULL)); 
    
    for (int i = 0; i < n; i++) {
        Item valor = rand() % m;
        lista = no(valor, lista);
    }
    
    return lista;
}

void exibe(Lista L) {
     printf("[");
     if(L == NULL){
     		
	 }else{
	 	printf("%d",L->item);
        L = L->prox;
		while( L != NULL ) {
	        printf(",%d",L->item);
	        L = L->prox;
	    }	
	
	 }
	 printf("]");
  }

int main(void) {
	int m = 100;
	int n = 0;
	
	printf("Informe a quantidade de numeros que deseja: ");
	scanf("%d", &n);
	    
    Lista lista_aleatoria = rnd(n, m);
    printf("\nLista de numeros aleatorios com %d itens entre 0 e %d:\n\n", n, m - 1);
    exibe(lista_aleatoria);
	
	return 0;
}
