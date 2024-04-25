#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pilha.h"

int expressaoBalanceada(const char *expressao) {
    Pilha P = pilha(strlen(expressao));

    for (int i = 0; expressao[i] != '\0'; i++) {
        if (expressao[i] == '{' || expressao[i] == '[' || expressao[i] == '(') {
            empilha(expressao[i], P);
        } else if (expressao[i] == '}' || expressao[i] == ']' || expressao[i] == ')') {
            if (vaziap(P)) {
                destroip(&P);
                return 0; 
            }

            char abertura = desempilha(P);
            if ((expressao[i] == '}' && abertura != '{') ||
                (expressao[i] == ']' && abertura != '[') ||
                (expressao[i] == ')' && abertura != '(')) {
                destroip(&P);
                return 0; 
            }
        }
    }

    int balanceada = vaziap(P);
    destroip(&P);
    return balanceada;
}

int main() {
    char expressao[100];

    printf("Digite uma expressao com chaves, colchetes e parenteses: ");
    fgets(expressao, 100, stdin);

    expressao[strcspn(expressao, "\n")] = '\0';

    if (expressaoBalanceada(expressao)) {
        printf("A expressao \"%s\" esta balanceada.\n", expressao);
    } else {
        printf("A expressao \"%s\" nao esta balanceada.\n", expressao);
    }

    return 0;
}

