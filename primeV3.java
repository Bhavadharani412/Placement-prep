import java.util.Scanner;
class primeV3
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
		until = (long) Math.sqrt(num);
		long start = System.currentTimeMillis();
		if ( num % 2 == 0)
		   factor_found_flag = true;
		   else
		   {
		for( cf = 3; cf <= until ; cf+=2)
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