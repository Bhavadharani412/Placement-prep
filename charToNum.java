import java.util.*;
public class charToNum
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String num = sc.nextLine();
	    String res = chartoNum(num);
 		System.out.println(res);
	}
	public static String chartoNum(String num){
	    String res = "";
	    int[] freq = new int[26];
	    for(int i = 0; i < num.length();i++){
	        char ch = num.charAt(i);
	        freq[ch-'a'] += 1;
	    }
	    //zero 
	    if(freq[25] != 0){
	        int c = freq[25];
	        res += "0".repeat(c);
	        freq[25] -= c; //z
	        freq[4] -= c; // e
	        freq[17] -= c; // r
	        freq[14] -= c; //o
	    }
	    // two
	    if(freq[22] != 0){
	        int c = freq[22];
	         res += "2".repeat(c);
	         freq[19] -= c; // t
	        freq[22] -= c; //w
	        freq[14] -= c; // o

	    }
	     // eight
	    if(freq[6] != 0){
	        int c = freq[6];
	         res += "8".repeat(c);
	         freq[4] -= c; // e
	        freq[8] -= c; //i
	        freq[6] -= c; // g
	        freq[7] -= c; // h
	        freq[19] -= c; // t

	    }
	    //six
	     if(freq[23] != 0){
	        int c = freq[23];
	         res += "6".repeat(c);
	         freq[18] -= c; // s
	        freq[8] -= c; //i
	        freq[23] -= c; // x

	    }
	     //four 
	    if(freq[20] != 0){
	        int c = freq[20];
	         res += "4".repeat(c);
	        freq[5] -= c; //f
	        freq[14] -= c; // o
	        freq[20] -= c ;// u
	        freq[17] -= c ;//r
	    }
	    //one
	    if(freq[14] != 0){
	        int c = freq[14];
	         res += "1".repeat(c);
	         freq[14] -= c ;// o
	        freq[13] -= c; //n
	        freq[4] -= c; // e
	    }
	    //three
	    if(freq[17] != 0){
	        int c = freq[17];
	         res += "3".repeat(c);
	         freq[19] -= c; // t
	        freq[7] -= c; //h
	        freq[17] -= c; // r
	        freq[4] -= c; // e
	        freq[4] -= c; // e

	    }
	    //five
	    if(freq[5] != 0){
	        int c = freq[5];
	         res += "5".repeat(c);
	        freq[5] -= c; //f
	        freq[8] -= c; // i
	        freq[21] -= c; // v
	        freq[4] -= c; //e
	    }
	      //seven
	    if(freq[18] != 0){
	        int c = freq[18];
	         res += "7".repeat(c);
	         freq[18] -= c; // s
	        freq[4] -= c; //e
	        freq[21] -= c; // v
	        freq[4] -= c; // e
	        freq[13] -= c; // n

	    } //nine
	    if(freq[4] != 0){
	        int c = freq[4];
	         res += "9".repeat(c);
	        freq[13] -= c; //n
	        freq[8] -= c; // i
	        freq[13] -= c; // n
	        freq[4] -= c; //e
	    }
	    
	    // 1, 2, 3, 4, 5, 6, 8,9, 0
		char[] arr = res.toCharArray();
	 	Arrays.sort(arr);
		res = new String(arr);
	    return res;
	}
}
