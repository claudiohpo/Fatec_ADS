#include <stdio.h>

void empurra(int v[], int PosicaoDestino){
  int NumeroMaior, IndiceMaior;
	for(int i = 0; i<PosicaoDestino; i++){
	    if(v[i]>NumeroMaior){
	        IndiceMaior = i;
	        NumeroMaior = v[i];
	    }
	}
	
	for(int i = IndiceMaior; i<PosicaoDestino; i++){
	    v[i] = v[i+1];
	}
	v[PosicaoDestino] = NumeroMaior;

}

void troca(int v[], int i, int j) {
	int x = v[i];
	v[i] = v[j];
	v[j] = x;
}

void bsort(int v[], int n) {
	for(int i=1; i<n; i++)
		for(int j=0; j<n-i; j++)
			if( v[j]>v[j+1] )
				troca(v,j,j+1);
}

void exibe(int v[],int n){
	for(int i=0; i<n; i++){
		printf("%d ", v[i]);
	}
}

int main(void) {
	int v[9] = {51,82,38,99,75,19,69,46,27};
    empurra(v,8);
    exibe(v,9);
	return 0;
}

