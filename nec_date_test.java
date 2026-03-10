class nec_date
{
   short folded;
nec_date ( int dd, int mm, int yyyy )
{
   
   folded = (short )( (yyyy-1980)*512 + (mm*32) + dd );
   
}
private  boolean isLeap( int year )
 {

     return ( ( (year%4==0) && (year%100!=0) ) || (year%400==0) ) ? true  : false ;
 }
nec_date addDate ( int nod  )// nod - number of days
                                  // gd  - given date
{
    int dd;
    int mm;
    int yyyy;
    int copy_nod;
    int nod_in_months [] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    yyyy = ( folded / 512 ) + 1980;
    mm   = ( folded % 512 ) / 32;
    dd   = ( folded % 512 ) % 32;
    copy_nod = nod;
    while (copy_nod != 0)
    {
    dd+=1;
    // boundary check
    if ( dd > nod_in_months [ mm ])
    {
        mm+=1;
        // feb check
        if ( mm == 2 )
        {
            nod_in_months [ 2 ] = isLeap( yyyy )? 29:28;
        }
        if ( mm > 12 )
        {
            mm = 1;
            yyyy +=1;
        }
        dd = 1;
    }
    copy_nod-=1;
    }
    nec_date sendBack = new  nec_date( dd, mm, yyyy);
    return sendBack;
}

void printDate( )
{
    int dd;
    int mm;
    int yyyy;
    yyyy = ( folded / 512 ) + 1980;
    mm   = (folded % 512 ) / 32;
    dd   = (folded % 512 ) % 32;
    System.out.printf("%02d/%02d/%d\n",dd,mm,yyyy);

}




}


class nec_date_test
{
	public static void main( String [] parameters )
	{
		
   // nec_date today = constructDate( 10,3,2026);
	nec_date today = new nec_date( 10, 3, 2026);
   // printDate ( today );
   today.printDate();
   // nec_date dob_bava = constructDate ( 4,12,2005);
      nec_date dob_bava = new nec_date ( 4,12,2005);
    int days_in_deposit;
    days_in_deposit = 10000;
    nec_date matDate = dob_bava.addDate(days_in_deposit);
    dob_bava.printDate(  );
    matDate.printDate(  );
    /*int age_in_days;
    age_in_days = diffDate( today, dob_bava );
    */

 
	}
}
