#include <stdio.h>
void troca(int *a, int *b) {
    int c = *a;
    *a = *b;
    *b = c;
}


int main(void) {
    int x = 5, y = 3;
    troca(&x, &y);
    printf("x: %d y: %d", x, y);
}
