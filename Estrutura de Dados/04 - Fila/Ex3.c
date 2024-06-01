#include <stdio.h>
#include "fila.h"
#define TIMESLICE 3 // tempo máximo de uso ininterrupto de CPU

int main(void) {
	Fila F =fila(5);
	enfileira(17,F); // 1º processo requer 7s para concluir sua execução
	enfileira(25,F);
	enfileira(39,F);
	enfileira(46,F);
	while( !vaziaf(F) ) {
		int x =desenfileira(F);
		int p =x/10;
		int t =x%10;
		if(t>3)enfileira(p*10+(t-TIMESLICE),F);
		else printf("Processo %d concluido\n",p);
	}
	destroif(&F);
	return 0;
}
