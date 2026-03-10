/*wrapper()
{
   f()
}


f()
{
   // arm length
   
   // set an environment
   
   // call a helper - recursive, pass , initiate
}

nod(num) // wrapper 
{
   // arm length - trivial and validations
   if ( num >= -9 && num < 10 ) ret 1;
   if ( num >= -99 && num < 100 ) ret 2;
   
   
   // set an environment - none 
   
   // call helper - recursive , pass, initiate
   return nod_helper( num );
}
int nod_helper ( int num )
{
   // base case
   if ( num==0) return 0;
   //                6974
     return;          1+nod_helper(num/10)
}
6974 => 4
1+nod_helper(697)
      1+nod_helper(69)
	      1+nod_helper(6)
		     1+ nod_helper(0)
*/



class rec_problems
{
    private static int nod_helper ( int data )
	{
	  // base case
	  if ( data == 0 ) return 0;
	  return 1+nod_helper( data/10 );
	}
    public static int nod( int data )
	{
      // arm length - trivial, validations
      if ( data >= -9 && data < 10 ) return 1;
      if ( data >= -99 && data < 100 ) return 2;
	  // set an environment
	  
	  // call helper - recursive, pass, initiate
	  return nod_helper ( data );
	  
	  
	  
	}
	private static int multiply_helper ( int mand, int mier )
	{
		// base 
		if ( mier == 1)
			return mand;
		return mand + multiply_helper ( mand, mier - 1);
	}
	public static int multiply ( int mulAnd, int mulIer)
	{
		 // arm length - validations, trivial
		 if ( mulAnd == 1) return mulIer;
		 if ( mulIer == 1) return mulAnd;
		 if ( mulIer == 0 || mulAnd == 0 )
			 return 0;
		 if ( mulAnd == -1 ) return -mulIer;
		 if ( mulIer == -1 ) return -mulAnd;
		 // set an environment
		 boolean return_negative;
		 return_negative = false;
		 if ( (mulAnd < 0 || mulIer < 0 ) && !(mulAnd < 0 && mulIer < 0))
			  return_negative = true;
		  // return_negative = ( mulAnd < 0 || mulIer < 0 );
		  int proc_mulAnd;
		  int proc_mulIer;
		  proc_mulAnd = mulAnd < 0 ? -mulAnd : mulAnd;
		  proc_mulIer = mulIer < 0 ? -mulIer : mulIer;
		  int prod;
		  int temp;
		  if ( proc_mulAnd < proc_mulIer )
		  {
			  temp = proc_mulAnd;
			  proc_mulAnd = proc_mulIer;
			  proc_mulIer = temp;
		  }
		  prod = multiply_helper( proc_mulAnd, proc_mulIer );
		  if ( return_negative == true )
			  return - prod;
		  return prod;
		 
	}
	private static int power_helper ( int base, int expo  )
	{
		// base case 
		if ( expo == 1)
			 return base;
		 return base * power_helper ( base, expo - 1);
	}
	public static int power( int base, int exponent )
	{
		// arm length , validations and trivial 
		if ( base == 0 && exponent == 1)
			return 1;
		if ( base == 0 )
			return 0;
		if ( exponent == 0)
			return 1;	
		if ( exponent == 1)
			return base;
		if ( base == 1)
			return 1;
		/*environment
		boolean return_negative;
		return_negative = false;
		return_negative = exponent % 2 == 1;*/
		return power_helper ( base, exponent );
		
		
	}
	 private static int sod_helper ( int data ) // 6974
	{
	  // base case
	  if ( data == 0 ) return 0;
	  return data%10  + sod_helper( data/10 );
	  // return 4  + sod_helper( 697 );
	  //              return 7 + sod_helper(69))
	  //                          return 9+ sod_helper(6)
	  //                                    return 6+sod_helper(0)
	  //                                                   0
	}
    public static int sod( int data )
	{
      // arm length - trivial, validations
      if ( data >= -9 && data < 10 )
	  {
		  // what ? How ?
		  if ( data <  0)
		  {
			   data = -data;
			  // data *= -1;
			  // data = 0 - data;
			  //data /= -1;
			  
		  }
	  }

	  // set an environment
	  
	  // call helper - recursive, pass, initiate
	  return sod_helper ( data );
	  
	  
	  
	}
	private static int reverse_helper (int data,int rp ) 
	{
		if ( data == 0 )
			return 0;
		return ( data % 10 ) * rp + reverse_helper(data/10, rp/10);
	}
	public static int reverse( int data )
	{
		// arm length - validations , trivial
		if ( data % 10 == 0)
			return -1;
		if ( data > -10 && data < 10 )
			return data;
		if ( data > -100 && data < 100 )
			return (data%10)*10 + (data/10) ;
	
		
		
		// environment 697429
		// 9 * 100000 + 2 * 10000 + 4*1000 + 7*100+9*10+6*1
		// 697429
		boolean negative_return;
		negative_return = false;
		int tempData;
		tempData = data;
		if ( tempData < 0 )
		{
			tempData = -tempData;
			negative_return = true;
		}
		
		int req_power;
		req_power = 1;
		while ( tempData / req_power > 9 )
		{
		  req_power*=10;
		}
		
		// call helper - recursive, pass environment, initiate
		
		int res = reverse_helper ( tempData, req_power);
		return negative_return == true ? -res : res;
	}
	// a * b = gcd(a,b) * lcm(a,b)
	// lcm(a,b) = (a*b)/gcd(a,b)
	public static void main( String [] parameters )
	{
	    int num;
		num = 6974;
		System.out.printf("number of digits of %d is %d\n", num, nod(num));
		System.out.printf("%d X %d = %d\n", 2,123456789,multiply(2,123456789));
		System.out.printf("%d ^ %d = %d\n", 2,31, power(2,31));
		System.out.printf("%d ^ %d = %d\n", -2,31, power(-2,31));
		System.out.printf("%d ^ %d = %d\n", -2,30, power(-2,30));
		System.out.printf("%d reversed is %d\n", 6974, reverse(6974));
		System.out.printf("%d reversed is %d\n", 6, reverse(6));
		System.out.printf("%d reversed is %d\n", 69, reverse(69));
		System.out.printf("%d reversed is %d\n", -6974, reverse(-6974));
		System.out.printf("%d reversed is %d\n", 69740, reverse(69740));
		
		
		
	}
}