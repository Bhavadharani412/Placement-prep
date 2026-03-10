import java.util.Scanner;

// cout << num1 << " " << num2 << " " << sum << endl;
// cout & operator << ( cout &, int)
// cout << num1
//     cout     << " "
//            cout << num2 
//                  cout << " " 
// strcpy( str2 ,strrev(str1, 4) );
import java.util.Random;
class rev_arr
{
    public static void print( int [] arr )
	{
	   int arr_ind;
	   int arr_size;
	   arr_size = arr.length;
  System.out.println("\n------START------");
	 	 
	 for( arr_ind = 0; arr_ind < arr_size; arr_ind++)
	   {  
	      System.out.printf("%d ", arr [ arr_ind ] );
	   }
	   System.out.println("\n------E  N  D------");
	   
	}
	public static int [] revArray ( int [] arr )
	{
	    int front;
		int last;
		int temp;
		front = 0;
		last = arr.length - 1;
		while ( front < last )
		{
		   temp = arr [ front ];
		   arr [ front ]  = arr [ last ];
		   arr [ last  ]  = temp; 
		   front++;
		   last--;
		}
		return arr;
	}
	public static int [] rotateArr ( int [] arr, int rotFactor)
	{
	}
	
	public static int [] revArray ( int [] arr , int fi, int li)
	{
	    int front;
		int last;
		int temp;
		front = fi;
		last = li;;
		while ( front < last )
		{
		   temp = arr [ front ];
		   arr [ front ]  = arr [ last ];
		   arr [ last  ]  = temp; 
		   front++;
		   last--;
		}
		return arr;
	}

	public static void main( String [] parameters )
	{
		int noe;
		Scanner kbrd = new Scanner ( System.in );
		noe = kbrd.nextInt();
		int [] arr = new int [ noe ];
		int arr_ind;
		Random rnd = new Random();
		for( arr_ind = 0; arr_ind < noe; arr_ind++)
		{
		   int value = rnd.nextInt();
		   if ( value < 0 )
		      value = -value;
		    value = 10 + (value % 90 );
           arr [ arr_ind ] = value;			
		}
		print( arr );
		revArray( arr );
		print( arr );
		print(revArray(arr, 0, 10));
		//print( arr );
	}
}