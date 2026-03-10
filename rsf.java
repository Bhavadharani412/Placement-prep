import java.util.*;
public class rsf
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int num = sc.nextInt();
	    int res = rsf(num);
	    while(res > 99) res = rsf(res);
 		System.out.println(res);
	}
	public static int rsf(int num){
	    int res = 0, temp = num;
	    int p = 0;
	    while(temp != 0){
	        temp/=10;
	        p++;
	    }
	    int power = (int)Math.pow(10, p-1);
	     for (int i = 0; i < p - 1; i++) {
	        int d1 = num/power;
	        num %= power;
	        power /= 10;
	        int d2 = num/power;
	        res = res * 10 + Math.abs(d1-d2);
	   }
           
	    return res;
	}
}

