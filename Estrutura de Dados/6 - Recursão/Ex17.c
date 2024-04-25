#include <stdio.h>
#include <string.h>

void inv(char *s, int p, int u) {
 
    if (p >= u)
        return;
    
    char temp = s[p];
    s[p] = s[u];
    s[u] = temp;
    
    inv(s, p + 1, u - 1);
}

int main() {
    char str[100];
    printf("Digite uma palavra: ");
    scanf("%s", str);
    
    int inicio = 0;
    int fim = strlen(str) - 1;
    inv(str, inicio, fim);
    
    printf("Palavra invertida: %s\n", str);
    
    return 0;
}
