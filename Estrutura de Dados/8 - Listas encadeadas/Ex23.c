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

int count(Item x, Lista L) {
    if (L == NULL) {
        return 0;
    }
    if (L->item == x) {
        return 1 + count(x, L->prox);
    } else {
        return count(x, L->prox);
    }
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
	printf("\nLista A: ");
    Lista L = no(3, no(1, no(5, no(1, no(6, no(0, no(1, NULL)))))));
    exibe(L);
    
    int num = 0;
    printf("\n\nInforme um item(numero) para verificar quantas vezes ele aparece na lista acima: ");
    scanf("%d",&num);
    
	int ocorrencias = count(num, L);
    if(count(num,L)){
    	printf("\nO item %d ocorre %d vezes na lista.\n", num, ocorrencias);	
	}else{
		printf("\nO item %d nao ocorre na lista.\n",num);	
	}
		
	return 0;
}
