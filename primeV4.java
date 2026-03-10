import java.util.Scanner;
class primeV4
{
	public static void main( String [] parameters )
	{
		long num;
		Scanner kbrd = new Scanner ( System.in );
		num = kbrd.nextLong();
		long  cf; // check for factor
		boolean factor_found_flag;
		factor_found_flag = false;
		long until;
		boolean incr_flag_two;
		until = (long) Math.sqrt(num);
		long start = System.currentTimeMillis();
		incr_flag_two = true;
		if ( num % 2 == 0 || num % 3 == 0)
		   factor_found_flag = true;
		   else
		   {
		for( cf = 5; cf <= until ; cf+=incr_flag_two==true?2:4,
		incr_flag_two = !incr_flag_two)
		{
		   if ( num % cf == 0 )
		   {
		      factor_found_flag = true;
		      break;
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