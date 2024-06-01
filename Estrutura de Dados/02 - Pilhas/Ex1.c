#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

int main(){
	int quantidade=0, cont=1, numero=0;
	
	printf("Informe a quantidade de numeros que serao inseridos: ");
	scanf("%i", &quantidade);
	
	Pilha pilhaA = pilha(quantidade);
	Pilha pilhaB = pilha(quantidade);
	
	while(quantidade >= cont){
		printf("Digite o %io numero: ", cont);
		scanf("%i", &numero);
		empilha(numero, pilhaA);
		cont++;
	}
	
	while (!vaziap(pilhaA)) {
    numero = desempilha(pilhaA);

    while (!vaziap(pilhaB) && topo(pilhaB) > numero) {
    	empilha(desempilha(pilhaB), pilhaA);
    }

    empilha(numero, pilhaB);
  	}
 	 while (!vaziap(pilhaB)) {
  		empilha(desempilha(pilhaB), pilhaA);
  	}	

  	printf("Numeros ordenados: ");
  	while (!vaziap(pilhaA)) {
    	printf("%d ", desempilha(pilhaA));
  	}

  	destroip(&pilhaA);
  	destroip(&pilhaB);
	
}

