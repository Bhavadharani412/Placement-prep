import java.util.Scanner;
class reduced_subtract_form
{
	public static void main( String [] parameters )
	{
		Scanner kbrd = new Scanner ( System.in );
		long input;
		long copy_input;
		long temp;
		int dig1;
		int dig2;
		int res_dig;
		
		input = kbrd.nextLong();
		copy_input = input;
		long power;
		long show;
		long safe_power;
		power=1;
		while ( input / power > 9 )
		{
		    power *=10;
		}
		safe_power = power;
		do
		{
		temp= 0;
		show = copy_input;
		while( power > 1)
		{
		dig1 = (int)(copy_input / power);
		dig2 = (int) (copy_input / (power/10))%10;
		copy_input %= power;
		power/=10;
		res_dig = ( dig1 - dig2 );
		if ( res_dig < 0 ) 
		   res_dig = -res_dig;
		temp = temp * 10 + res_dig;
		//System.out.printf("temp = %d\n", temp);
        }		
		
		
		System.out.printf("%d=>%d\n", show, temp);
		safe_power/=10;
		power = safe_power ;
		copy_input = temp;
		} while ( copy_input > 99);
		
		
		
		
	}
}