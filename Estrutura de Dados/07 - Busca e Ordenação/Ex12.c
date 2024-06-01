#include <stdio.h>

int rbsearch(int x, int v[], int p, int u) {
    
    if (p > u) {
        return 0;
    }
    
    int meio = (p + u) / 2;
    
    if (v[meio] == x) {
        return 1;
    }
 
    else if (x < v[meio]) {
        return rbsearch(x, v, p, meio - 1);
    }
    
    else {
        return rbsearch(x, v, meio + 1, u);
    }
}

int main(void) {
   int v[8] = {19,27,31,48,52,66,75,80};
   printf("27: %d\n", rbsearch(27,v,0,7));
   printf("51: %d\n", rbsearch(51,v,0,7));
   return 0;
}

