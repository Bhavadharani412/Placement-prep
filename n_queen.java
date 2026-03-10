import java.util.Scanner;
class n_queen
{
	private static void printCB ( int [] qpos )
	{
		int ro;
		int co;
		int size;
		size = qpos.length;
		for( ro = 0; ro < size; ro++, System.out.println())
		{
			for ( co =0; co < size; co++)
			{
				System.out.printf("%c ", qpos[ro]==co ? 'Q' : '-');
			}
		}
	}
    private static boolean isSafe( int [] q_pos, int qno, int pos )
	{
	   int ro;
	   int co;
	   int noq;
	   noq = q_pos.length;
	   // left up diagonal
	   for( ro = qno-1,  co = pos -1; ro >= 0 && co >= 0; ro--,co--)
	   {
	      if ( q_pos [ ro ] == co )
		     return false;
	   }
	   // up
	   for( ro = qno-1,  co = pos; ro >= 0 ; ro--)
	   {
	      if ( q_pos [ ro ] == co )
		     return false;
	   }
		   
	   // right up diagonal
	   for( ro = qno-1,  co = pos + 1 ; ro >= 0 && co < noq; ro--,co++)
	   {
	      if ( q_pos [ ro ] == co )
		     return false;
	   }
	   return true;
	}
    private static void nq_helper ( int [] qpos, int noq, int qno )
	{
	   // check
	   if ( noq == qno )
	   {
	       System.out.println("Solved!!!!!!");
		   printCB( qpos );
		   for( int iter = 0; iter < Math.pow(2,16); iter++);
		   return;
	   }
	   // enumerate all choices
	   // 0 ,1 .....noq-1
	   
	   // loop thru all choices, choose, as per constraint
	   int pos;
	   for( pos = 0; pos < noq ; pos++)
	   {
	      if ( isSafe(qpos, qno, pos)== true )
		  {
		     qpos [ qno ] = pos;
			 nq_helper ( qpos, noq, qno + 1);
			 qpos [ qno ] = -1;
		  }
	   }
	}
    public static void n_queen_solver( int noq )
	{
	   // arm length - validation, trivial
	   if ( noq < 4)
	      return;
	// set an environment
	   int [] q_pos = new int [ noq ];
	   int q_pos_ind;
	   for ( q_pos_ind = 0; q_pos_ind < noq; q_pos_ind++)
	   {
	     q_pos [ q_pos_ind ] = -1;
	   }
	// call helper - recursive, pass, initiate
	nq_helper( q_pos, noq, 0 );
	   
	   
		  
	}
	public static void main( String [] parameters )
	{
		Scanner kbrd = new Scanner ( System.in );
		int noq;
		noq = kbrd.nextInt();
		n_queen_solver( noq );
	}
}