#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pilha.h"
#include <ctype.h>

int prio(char o) {
    switch (o) {
        case '(':
            return 0;
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
    }
    return -1; // operador inválido!
}

int valpre(char *e) {
    int len = strlen(e);
    _strrev(e); // Inverte a expressão prefixa
    Pilha P = pilha(len);

    for (int i = 0; i < len; i++) {
        if (isdigit(e[i])) {
            empilha(e[i] - '0', P); // Converte o caractere numérico para inteiro e empilha
        } else if (strchr("+-*/", e[i])) {
            if (vaziap(P)) {
                printf("Erro: Pilha vazia durante a avaliação da expressão prefixa.\n");
                destroip(&P);
                return -1;
            }

            int x = desempilha(P);

            if (vaziap(P)) {
                printf("Erro: Pilha vazia durante a avaliação da expressão prefixa.\n");
                destroip(&P);
                return -1;
            }

            int y = desempilha(P);

            switch (e[i]) {
                case '+':
                    empilha(x + y, P);
                    break;
                case '-':
                    empilha(x - y, P);
                    break;
                case '*':
                    empilha(x * y, P);
                    break;
                case '/':
                    if (y == 0) {
                        printf("Erro: Divisão por zero.\n");
                        destroip(&P);
                        return -1;
                    }
                    empilha(x / y, P);
                    break;
            }
        }
    }

    if (vaziap(P)) {
        printf("Erro: Pilha vazia após avaliação da expressão prefixa.\n");
        destroip(&P);
        return -1;
    }

    int resultado = desempilha(P);
    destroip(&P);
    return resultado;
}

char *prefixa(char *e) {
    int len = strlen(e);
    _strrev(e); // Inverte a expressão infixa
    Pilha P = pilha(len);
    char *prefixa = (char *)malloc(len * sizeof(char));
    int j = 0;

    for (int i = 0; i < len; i++) {
        if (e[i] == ')') {
            empilha(')', P);
        } else if (e[i] == '(') {
            while (!vaziap(P) && topo(P) != ')') {
                prefixa[j++] = desempilha(P);
            }
            desempilha(P); // Descarta o parêntese de fechamento
        } else if (isdigit(e[i])) {
            prefixa[j++] = e[i];
        } else if (strchr("+-*/", e[i])) {
            while (!vaziap(P) && prio(topo(P)) >= prio(e[i])) {
                prefixa[j++] = desempilha(P);
            }
            empilha(e[i], P);
        }
    }

    while (!vaziap(P)) {
        prefixa[j++] = desempilha(P);
    }

    prefixa[j] = '\0';
    _strrev(prefixa); // Inverte a expressão prefixa para a forma correta
    destroip(&P);

    return prefixa;
}

int main() {
    char infixa[513];
    printf("Digite a expressao infixa completamente parentesiada: ");
    fgets(infixa, sizeof(infixa), stdin);
    infixa[strcspn(infixa, "\n")] = '\0'; // Remover o caractere de nova linha

    char *prefixa_result = prefixa(infixa);
    printf("Forma prefixa da expressao: %s\n", prefixa_result);

    int resultado = valpre(prefixa_result);
    if (resultado != -1) {
        printf("Resultado da expressao: %d\n", resultado);
    }

    free(prefixa_result); // Liberar a memória alocada
    return 0;
}
