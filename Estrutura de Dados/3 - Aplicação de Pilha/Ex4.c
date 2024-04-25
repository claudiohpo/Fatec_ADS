#include <stdio.h>
#include "pilha.h"
#include <ctype.h>
#include <string.h>

int prio(char o) {
    switch (o) {
        case '(':
            return 0;
        case '!':
            return 3;
        case '&':
            return 2;
        case '|':
            return 1;
    }
    return -1; // operador inválido!
}

char *posfixa(char *e) {
    static char s[256];
    int j = 0;
    Pilha P = pilha(256);
    for (int i = 0; e[i]; i++) {
        if (e[i] == '(')
            empilha('(', P);
        else if (e[i] == 'F' || e[i] == 'V')
            s[j++] = e[i];
        else if (strchr("!&|", e[i])) {
            while (!vaziap(P) && prio(topo(P)) >= prio(e[i]))
                s[j++] = desempilha(P);
            empilha(e[i], P);
        } else if (e[i] == ')') {
            while (topo(P) != '(')
                s[j++] = desempilha(P);
            desempilha(P);
        }
    }
    while (!vaziap(P))
        s[j++] = desempilha(P);
    s[j] = '\0';
    destroip(&P);
    return s;
}

int avalia(char *e) {
    Pilha P = pilha(256);
    for (int i = 0; e[i]; i++) {
        if (e[i] == 'F')
            empilha(0, P);
        else if (e[i] == 'V')
            empilha(1, P);
        else if (strchr("!&|", e[i])) {
            int x, y;
            switch (e[i]) {
                case '!':
                    x = desempilha(P);
                    empilha(!x, P);
                    break;
                case '&':
                    y = desempilha(P);
                    x = desempilha(P);
                    empilha(x && y, P);
                    break;
                case '|':
                    y = desempilha(P);
                    x = desempilha(P);
                    empilha(x || y, P);
                    break;
            }
        }
    }
    int result = desempilha(P);
    destroip(&P);
    return result;
}

int main(void) {
    char infixa[513];

    printf("Infixa? ");
    fgets(infixa, sizeof(infixa), stdin);
    infixa[strcspn(infixa, "\n")] = '\0'; // Remover o caractere de nova linha

    printf("Posfixa: %s\n", posfixa(infixa));
    printf("Resultado: %d\n", avalia(posfixa(infixa)));
    return 0;
}

