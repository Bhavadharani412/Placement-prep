import java.util.Scanner;
/*
Algorithm
1000	500	100	50	10	5	1	
1000		M
900			CM
500			D	
400			CD
100			C 
90			XC
50			L	
40			XL
10			X 
9			IX
5			V
4			IV
1			I 
*/
class integer_2_roman
{
	public static void main( String [] parameters )
	{
		Scanner kbrd = new Scanner ( System.in );
		int value;
		String roman="";
		value = kbrd.nextInt();
		int copy;
		copy = value;
		while ( copy != 0)
		{
		   if ( copy >= 1000)
		   {
		       roman +="M";
			   copy -= 1000;
		   } else  if ( copy >= 900)
		   {
		       roman +="CM";
			   copy -= 900;
		   } else if ( copy >= 500)
		   {
		       roman +="D";
			   copy -= 500;
		   }else  if ( copy >= 400)
		   {
		       roman +="CD";
			   copy -= 400;
		   }else  if ( copy >= 100)
		   {
		       roman +="C";
			   copy -= 100;
		   }else  if ( copy >= 90)
		   {
		       roman +="XC";
			   copy -= 90;
		   }else  if ( copy >= 50)
		   {
		       roman +="L";
			   copy -= 50;
		   }else  if ( copy >= 40)
		   {
		       roman +="XL";
			   copy -= 40;
		   }else  if ( copy >= 10)
		   {
		       roman +="X";
			   copy -= 10;
		   }else  if ( copy >= 9)
		   {
		       roman +="IX";
			   copy -= 9;
		   }else  if ( copy >= 5)
		   {
		       roman +="V";
			   copy -= 5;
		   }else  if ( copy >= 4)
		   {
		       roman +="IV";
			   copy -= 4;
		   }
		   else  
		   {
		       roman +="I";
			   copy -= 1;
		   }
		   
		}
		
		
		System.out.printf("%d = %s\n", value, roman);
	}
}