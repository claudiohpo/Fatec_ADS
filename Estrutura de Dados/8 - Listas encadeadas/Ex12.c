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

Lista intervalo(int p, int u) {
    Lista lista = NULL;
    
    if (p > u) {
        return lista;
    }
    
    for (int i = p; i <= u; i++) {
        lista = no(i, lista);
    }
    
    return lista;
}

Lista inversa(Lista L) {
    Lista invertida = NULL;
    while (L != NULL) {
        invertida = no(L->item, invertida);
        L = L->prox;
    }
    return invertida;
}

void exibe(Lista L) {
     printf("[");
	 while( L != NULL ) {
        printf("%d", L->item);
        if (L->prox != NULL) {
            printf(",");
        }
        L = L->prox;
     }
     printf("]");
}

int main(void) {
   int p, u;
    printf("Digite o intervalo de dois numeros (separados por espaco): ");
    scanf("%d %d", &p, &u);
    
	Lista L = intervalo(p, u);
	Lista L_invertida = inversa(L);
    printf("\nIntervalo escolhido: %d...%d\n\n",p,u);
    printf("Lista: \n");
    exibe(L_invertida);
   
   return 0;
}

