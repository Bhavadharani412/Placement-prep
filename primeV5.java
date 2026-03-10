import java.util.Scanner;
class primeV5
{
	public static void main( String [] parameters )
	{
		long num;
		Scanner kbrd = new Scanner ( System.in );
		num = kbrd.nextLong();
		//long  cf; // check for factor
		boolean factor_found_flag;
		factor_found_flag = false;
		long until;
		boolean incr_flag_two;
		until = (long) Math.sqrt(num);
		long [] cf = {7,11,13,17,19,23,29,31};
		int cf_ind;
		// indices
		// 
		// 1000 1004 1008 1012 1016 1020 1024
		// ^
		// 0    1
		// a^b 
		long start = System.currentTimeMillis();
		incr_flag_two = true;
		if ( num % 2 == 0 || num % 3 == 0 || num % 5 == 0)
		   factor_found_flag = true;
		   else
		   {
		   outer:
		      while ( true )
			  {
				  for( cf_ind = 0; cf_ind < cf.length; cf_ind++)
				  {
					  if ( cf [ cf_ind ] > until )
						  break outer;
					  if ( num % cf [ cf_ind ] == 0 )
					  {
						 factor_found_flag = true;
						 break outer;
					  }
					  else
					  {
						 cf [ cf_ind ] += 30;
					  }
				  }
			  }
		   }
		// 14 0r 10 
		long stop = System.currentTimeMillis();
		double duration = ( stop - start ) / 1000.0;
		
		System.out.printf("%s\n", factor_found_flag == true ? "Composite":"Prime");
	    System.out.printf("num is %d, time taken = %.3f", num, duration);
	}
}