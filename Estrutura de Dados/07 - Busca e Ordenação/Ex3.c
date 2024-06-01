#include <stdio.h>
#include <stdlib.h>

void troca(int v[], int i, int j) {
    int temp = v[i];
    v[i] = v[j];
    v[j] = temp;
}
void empurra(int v[], int u) {
    if (u <= 0) return; 

    int max_idx = 0;
    for (int i = 1; i <= u; i++) {
        if (v[i] > v[max_idx]) {
            max_idx = i; 
        }
    }
    troca(v, max_idx, u);
    empurra(v, u - 1); 
}
void bsr(int v[], int n) {
    if (n <= 1) return; 

    empurra(v, n - 1); 
    bsr(v, n - 1); 
}
void exibe(int v[], int n) {
    printf("{");
    for (int i = 0; i < n; i++) {
        printf("%d", v[i]);
        if (i < n - 1) printf(",");
    }
    printf("}\n");
}
int main(void) {
    int v[9] = {51, 82, 38, 99, 75, 19, 69, 46, 27};
    bsr(v, 9);
    exibe(v, 9);
    return 0;
}
