#include <stdio.h>

int rlsearch(int x, int v[], int n, int i) {
    
    if (i == n) {
        return 0;
    }
    
    if (v[i] == x) {
        return 1;
    }
    
    return rlsearch(x, v, n, i + 1);
}

int main(void) {
   int v[8] = {66,80,31,48,27,75,19,52};
   printf("27: %d\n", rlsearch(27,v,8,0));
   printf("51: %d\n", rlsearch(51,v,8,0));
   return 0;
}


