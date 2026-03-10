// name 	100 	1000 	10000 	100000 	10000000
// sel  	0.67
/*
Sort

rerrange the data
such that every element can claim that on one side
it is filled with <= and on the other side it is filled
with >=


Focus on a place and get the appropriate value
Focus on a value and get the appropriate place 

Stable - duplicate values retain their order of appearance

Unstable - duplicate values their order of appearance is lost

Sort - comparison of values
sort - without comparison of values

internal - internal memory
external - disks

*/

import java.util.Scanner;
import java.util.Random;
class sort_sinking_flagged
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
	private static void swap ( int [] arr, int pos1, int pos2 )
	{
	   int temp;
	   temp = arr [ pos1 ];
	   arr [ pos1 ] = arr [ pos2 ];
	   arr [ pos2 ] = temp;
	}
	public static int [] sinkingSort ( int [] data )
	{
	    int pass_number;
		int data_ind;
		int data_size;
		data_size = data.length;
		boolean swap_happened;
		swap_happened = false;
		for( pass_number = 0; pass_number < data_size && 
		swap_happened == false ; pass_number++)
		{
		  swap_happened = false;
			for( data_ind =0; data_ind < data_size - (pass_number+1); data_ind++)
			{
				 if ( data [ data_ind ] > data [ data_ind + 1] )
				 {
					 swap( data, data_ind, data_ind+1);
					 swap_happened = true;
				 }
			}
		}
		   return data;
	}
	public static int [] selectionSort ( int [] data )
	{
	   // 0 to n-1 and get value for index 0
	   // 1 to n-1 and get value for index 1
	   // 2 to n-1 and get value for index 2
	   int min;
	   int mp; // pos of minimum element
	   int data_ind;
	   int data_size;
	   data_size = data.length;
	   for ( int scopeBegin = 0; scopeBegin < data_size; scopeBegin++)
	   {
	      // set the environment
		  min = Integer.MAX_VALUE;
		  mp = -1;
		  for( data_ind = scopeBegin; data_ind < data_size; data_ind++)
		  {
		      if ( data [ data_ind ] < min )
			  {
			      min = data [ data_ind ];
				  mp = data_ind;
			  }
		  }
		  swap ( data, scopeBegin, mp);
	   }
	   
	   return data;
	   
	   
	   
	   
	   
	   
	   
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
		//print( arr );
		long begin = System.currentTimeMillis();
	    //selectionSort ( arr );
		sinkingSort( arr );
		//print( arr );
		long stop  = System.currentTimeMillis();
		double timeTaken = ( stop - begin ) / 1000.0;
		System.out.printf("%s Sort NOE = %d, duration = %.3f","S i n k i n g ", noe, timeTaken);
		
		
		
	}
}