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

typedef struct dic {
   int tam;
   Map *vet;
} *Dic;

Map no_map(Chave c, Valor v, Map p) {
    Map n = malloc(sizeof(struct map));
    strcpy(n->chave, c);
    strcpy(n->valor, v);
    n->prox = p;
    return n;
}

Dic dic(int m) {
    Dic d = malloc(sizeof(struct dic));
    d->tam = m;
    d->vet = malloc(m * sizeof(Map));
    for (int i = 0; i < m; i++) d->vet[i] = NULL;
    return d;
}

void insm(Chave c, Valor v, Map *M) {
    while (*M && strcmp(c, (*M)->chave) > 0)
        M = &(*M)->prox;
    if (*M && strcmp(c, (*M)->chave) == 0)
        strcpy((*M)->valor, v);
    else
        *M = no_map(c, v, *M);
}

void remm(Chave c, Map *M) {
    while (*M && strcmp(c, (*M)->chave) > 0)
        M = &(*M)->prox;
    if (*M == NULL || strcmp(c, (*M)->chave) != 0) return;
    Map n = *M;
    *M = n->prox;
    free(n);
}

int pertm(Chave c, Valor v, Map M) {
    while (M && strcmp(c, M->chave) > 0)
        M = M->prox;
    if (M && strcmp(c, M->chave) == 0)
        strcpy(v, M->valor);
    return (M && strcmp(c, M->chave) == 0);
}

void exibem(Map M) {
    printf("[");
    while (M) {
        printf("(%s,%s)", M->chave, M->valor);
        if (M->prox) printf(",");
        M = M->prox;
    }
    printf("]\n");
}

unsigned hash(char *c, int m) {
    unsigned s = 0;
    for (int i = 0; c[i]; i++)
        s += (i + 1) * c[i];
    return (s % m);
}

void insd(Chave c, Valor v, Dic d) {
    insm(c, v, &d->vet[hash(c, d->tam)]);
}

void remd(Chave c, Dic d) {
    remm(c, &d->vet[hash(c, d->tam)]);
}

int pertd(Chave c, Valor v, Dic d) {
    return pertm(c, v, d->vet[hash(c, d->tam)]);
}

void exibed(Dic d) {
    for (int i = 0; i < d->tam; i++) {
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
    for (int i = 0; i < (*d)->tam; i++)
        destroim(&(*d)->vet[i]);
    free((*d)->vet);
    free(*d);
    *d = NULL;
}

int main(void) {
    Dic D = dic(3);
    insd("bat", "morcego", D);
    insd("pig", "porco", D);
    insd("cat", "gato", D);
    insd("dog", "cachorro", D);
    insd("cow", "vaca", D);
    exibed(D);
    destroid(&D);
    return 0;
}

