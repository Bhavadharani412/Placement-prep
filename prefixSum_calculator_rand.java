import java.util.Scanner;
import java.util.Random;

class prefixSum_calculator_rand
{
    public static int [] prefixSum ( int [] arr )
	{
	   int arr_ind;
	   int arr_size;
	   arr_size = arr.length;
       int calcSum;
       int [] prefixArr = new int [ arr_size ];
	   calcSum = 0;
       for( arr_ind = 0; arr_ind < arr_size; arr_ind ++)
       {
	       calcSum += arr [ arr_ind ];
		   prefixArr [ arr_ind ] = calcSum - arr [ arr_ind ];
       }	   
	   return prefixArr;
	}
	
	public static int [] print( int [] arr )
	{
	   int arr_ind;
	   int arr_size;
	   arr_size = arr.length;
	   System.out.println("------B E G I N------");
	   for( arr_ind  = 0; arr_ind < arr_size; arr_ind++)
	    {
		     System.out.printf("%03d ", arr [ arr_ind ] );
		}
	   System.out.println("\n------E   N   D------");
		
		return arr;
	}
	public static void main( String [] parameters )
	{
		//int [] arr = {23,12,56,78,11,33,55,78,27,80,93,46,79,20,17,80,37,27,15,34};
		Scanner kbrd = new Scanner ( System.in );
		int noe;
		noe = kbrd.nextInt();
		int [] arr = new int [ noe ];
		
		Random rnd = new Random();
		int arr_ind ;
		for( arr_ind = 0; arr_ind < noe; arr_ind ++)
		{
			int val = rnd.nextInt() % 9000;
			if ( val <  0)
				val *=-1;
			val+=1000;
		    arr [ arr_ind ]  = val;
		}
		
		int [] prefixSum_arr;
		print( arr );
		prefixSum_arr = prefixSum ( arr );
		print( prefixSum_arr);
	}
}