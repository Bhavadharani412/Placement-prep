import java.util.Scanner;
class primeV1
{
	public static void main( String [] parameters )
	{
		int num;
		Scanner kbrd = new Scanner ( System.in );
		num = kbrd.nextInt();
		int cf; // check for factor
		boolean factor_found_flag;
		factor_found_flag = false;
		int until;
		until = num/2;
		long start = System.currentTimeMillis();
		for( cf = 2; cf <= until ; cf++)
		{
		   if ( num % cf == 0 )
		   {
		      factor_found_flag = true;
		      break;
		   }
		  
		}
		// 14 0r 10 
		long stop = System.currentTimeMillis();
		double duration = ( stop - start ) / 1000.0;
		
		System.out.printf("%s\n", factor_found_flag == true ? "Composite":"Prime");
	    System.out.printf("num is %d, time taken = %.3f", num, duration);
	}
}
