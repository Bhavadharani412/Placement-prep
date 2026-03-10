class suffixSum_calculator
{
    public static int [] suffixSum ( int [] arr )
	{
	   int arr_ind;
	   int arr_size;
	   arr_size = arr.length;
       int calcSum;
       int [] suffixArr = new int [ arr_size ];
	   calcSum = 0;
       for( arr_ind = arr_size - 1; arr_ind >=0; arr_ind --)
       {
	       calcSum += arr [ arr_ind ];
		   suffixArr [ arr_ind ] = calcSum - arr [ arr_ind ];
       }	   
	   return suffixArr;
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
		int [] arr = {23,12,56,78,11,33,55,78,27,80,93,46,79,20,17,80,37,27,15,34};
		int [] suffixSum_arr;
		print( arr );
		suffixSum_arr = suffixSum ( arr );
		print( suffixSum_arr);
	}
}