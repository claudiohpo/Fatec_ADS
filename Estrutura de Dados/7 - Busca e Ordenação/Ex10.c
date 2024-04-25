#include <stdio.h>


int bsearch(int x, int v[], int n) {
   int p = 0;
   int u = n-1;
   while( p<=u ) {
      int m = (p+u)/2;
      if( x==v[m] ) return 1;
      if( x<v[m] ) u = m-1;
      else p = m+1; 
   }
   return 0;
}

int main(void) {
   int v[8] = {19,27,31,48,52,66,75,80};
   printf("27: %d\n", bsearch(27,v,8));
   printf("51: %d\n", bsearch(51,v,8));
   return 0;
}

