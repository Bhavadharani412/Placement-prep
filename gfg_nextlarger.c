// 2: 50
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define DEBUG
// 87745864798
// 01234567890
void solve( char * str )
{
    int poi;
    // find the point of inflection
    for( poi= strlen( str ) - 1; poi > 0 ; poi --)
    {

       if ( str[ poi - 1] < str [ poi ])
          break;

    }
    //      V
    // 218765
    // 012345
    //  ^

    #ifdef DEBUG
     printf("poi = %d\n", poi);
    #endif // DEBUG

    poi--;
    int nl; // next larger
    int nl_swap;
    char large= str[poi+1];

    for( nl = poi+2; str[nl]; nl++)
    {
       if ( str [ nl ] > str [ poi ] && str [ nl ] < large)
       {
           nl_swap = nl;
           large = str [  nl ];
       }

    }
//218675
//     ^
     // 218756





    // find the next larger

    // swap
    char temp;
    temp = str [ poi ];
    str [ poi ] = str [ nl_swap ];
    str [ nl_swap ] = temp;
    // reverse

    strrev(str+(poi+1));

}
int main()
{
   char inp [1000];
   scanf("%s", inp);
   solve( inp);
   printf("%s ", inp);

    return EXIT_SUCCESS;
}
