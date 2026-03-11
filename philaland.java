import java.util.Scanner;
class philaland{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        if(n == 1) ans = 1;
        while (n != 0) {
            ans++;
            n >>= 1; 
        }
        System.out.println(ans);
        sc.close();
    }
}
