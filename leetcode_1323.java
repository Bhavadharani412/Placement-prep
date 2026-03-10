/*


9999969969
          ^
9999999969

9999999969

*/
import java.util.Scanner;
class leetcode_1323 
{
	public static void main( String [] parameters )
	{
		Scanner kbrd = new Scanner ( System.in );
//Scanner    kbrd         =           new       Scanner ( System.in );
//class      reference   assignment  memory      class   call the
//                       operator    allocation          CONsTRUCtOR
//                                   operator  		with System.in as parameter
        long num;
		
		long res;
		int digit;
		long power;
		long copy;
		boolean altered;
		
		// populate
		num = kbrd.nextLong();
		
		// priming
		res = 0;
		altered = false;
		// processing
		
		// find the power
		// 99969
		// 1 10 100 1000 10000
		power = 1;
		copy = num;
		while ( copy / power > 9 )
		{
		power *=10;
		}
		while ( power > 0 )
		{
		digit = (int)(copy / power);
		if ( digit == 6 && altered == false)
		{
		   res = res * 10 + 9;
		   altered = true;
		}
		else
           res = res * 10 + digit;
        copy %= power;
        power /= 10;
        }		
		System.out.printf("%d becomes %d\n", num, res );
		
		
		
		
		
		
		
		
	}
}