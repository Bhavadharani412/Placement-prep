class polyDivisible_ten
{
   private static void pd_helper ( boolean [] used, int currValue, int currDigit)
   {
   // check
   if ( currDigit == 10)
   {
      System.out.println( currValue );
	  return;
   }
      // enumerate all the choices
	  // 1 to 9
	  int digit;
	  for( digit = 1; digit < 10; digit++)
	  {
	      if ( used [ digit ] == false )
		  {
		     int newValue = currValue * 10 + digit;
			 if ( newValue % currDigit == 0 )
			 {
			     used [ digit ] = true;
				 pd_helper ( used, newValue, currDigit+1);
				 used [ digit ] = false;
			 }
		  }
	  }
   }
   public static void polyDivisible ( int base )
   {
      // arm length - validation , trivial
	  
	  // set an environment
	  boolean [] used = new boolean [ base ];
	  
	  // call recursive -  pass, initiate
	  pd_helper ( used, 0, 1);
	  
   }
	public static void main( String [] parameters )
	{
		polyDivisible( 10 );
	}
}