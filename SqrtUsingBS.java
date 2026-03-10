//###### Sat Mar 7 00:56:54 IST 2026

public class SqrtUsingBS {

    private static void sqrt_helper(double number, double start, double end) {
        double mid = (start + end) / 2.0;
        double sq = mid * mid;
        if (Math.abs(sq - number) < 0.0000001) {
            mid = (double) ((int) (mid * 1000)) / 1000.0;
            System.out.printf(mid + " is the sqrt of " + number);
            return;
        } else if (sq < number) {
            sqrt_helper(number, mid, end);
        } else {
            sqrt_helper(number, start, mid);
        }
    }

    public static void findSqrt(int number) {
        double num = (double) number;

        if (number < 1)
            return;
        if (number == 1)
            System.out.println(1);

        sqrt_helper(num, 1, num);
    }

    public static void main(String[] args) {
        findSqrt(100);
    }
}
