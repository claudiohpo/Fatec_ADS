#include <stdio.h>
#include <string.h>
#include <ctype.h>

int pal(char *s, int p, int u) {
    
    if (p >= u)
        return 1;
    
    while (isspace(s[p])) p++;
    while (isspace(s[u])) u--;

    if (tolower(s[p]) != tolower(s[u]))
        return 0;
    
    return pal(s, p + 1, u - 1);
}

int main() {
    char str[100];
    printf("Digite uma palavra ou frase: ");
    fgets(str, sizeof(str), stdin);
    str[strcspn(str, "\n")] = '\0'; 

    int inicio = 0;
    int fim = strlen(str) - 1;

    if (pal(str, inicio, fim))
        printf("A string \"%s\" eh um palindromo.\n", str);
    else
        printf("A string \"%s\" nao eh um palindromo.\n", str);
    
    return 0;
}

