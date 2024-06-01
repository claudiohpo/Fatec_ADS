#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pilha.h"

void inverterPalavras(char *frase) {
    Pilha pilhaLetras = pilha(strlen(frase));

    int i = 0;
    while (frase[i] != '\0') {
        
        if (frase[i] == ' ') {
            
            while (!vaziap(pilhaLetras)) {
                printf("%c", desempilha(pilhaLetras));
            }
            printf(" "); 
        } else {
            
            empilha(frase[i], pilhaLetras);
        }
        i++;
    }

    
    while (!vaziap(pilhaLetras)) {
        printf("%c", desempilha(pilhaLetras));
    }

    destroip(&pilhaLetras);
}

int main() {
    char frase[100];

    printf("Digite uma frase: ");
    fgets(frase, 100, stdin);

    printf("Frase com as letras invertidas:\n");
    inverterPalavras(frase);

    return 0;
}

