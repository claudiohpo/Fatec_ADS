#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char Chave[22];
typedef char Valor[22];

typedef struct map {
    Chave chave;
    Valor valor;
    struct map *prox;
} *Map;

Map no_map(Chave c, Valor v, Map p) {
    Map n = malloc(sizeof(struct map));
    strcpy(n->chave, c);
    strcpy(n->valor, v);
    n->prox = p;
    return n;
}

void insm(Chave c, Valor v, Map *M) {
    while (*M && strcmp(c, (*M)->chave) > 0)
        M = &(*M)->prox;
    if (*M && strcmp(c, (*M)->chave) == 0)
        strcpy((*M)->valor, v);
    else
        *M = no_map(c, v, *M);
}

void exibem(Map M) {
    printf("[");
    while (M) {
        printf("(%s,%s)", M->chave, M->valor);
        if (M->prox)
            printf(",");
        M = M->prox;
    }
    printf("]\n");
}

int main(void) {
    Map I = NULL;
    int tamanho;
    Chave chave;
    Valor valor;

    printf("Digite a quantidade de chaves que o mapeamento tera (Somente Numeros): ");
    scanf("%d", &tamanho);

    for (int i = 1; i <= tamanho; i++) {
        printf("Digite a %da. chave:\n", i);
        scanf("%s", chave);

        printf("Digite o valor referente ao %do. valor:\n", i);
        scanf("%s", valor);

        insm(chave, valor, &I);
    }

    exibem(I);

    Map tmp;
    while (I != NULL) {
        tmp = I;
        I = I->prox;
        free(tmp);
    }

    return 0;
}

