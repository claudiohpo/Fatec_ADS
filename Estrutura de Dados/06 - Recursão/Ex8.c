#include <stdio.h>

void hanoi(int n, char origem, char auxiliar, char destino) {
    if (n == 1) {
        printf("Mova o disco superior da torre %c para a torre %c\n", origem, destino);
        return;
    }

    hanoi(n - 1, origem, destino, auxiliar);
    printf("Mova o disco superior da torre %c para a torre %c\n", origem, destino);
    hanoi(n - 1, auxiliar, origem, destino);
}

int main() {
    int num_discos;
    printf("Digite o numero de discos: ");
    scanf("%d", &num_discos);

    printf("Passos para resolver o problema das Torres de Hanoi com %d discos:\n", num_discos);
    hanoi(num_discos, 'A', 'B', 'C');

    return 0;
}

