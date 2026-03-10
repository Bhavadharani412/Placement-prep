//###### Sat Mar 7 00:49:19 IST 2026  ## BALAKUMARAN
public class Euler719 {

    private static boolean BTHelper(long number, long sqrt, long current, int parts) {

        // Base case
        if (number == 0) {
            return current == sqrt && parts >= 2;
        }

        long part = 0;
        long power = 1;

        while (number / power > 0) {

            part = number % (power * 10);

            if (current + part <= sqrt) {
                if (BTHelper(number / (power * 10), sqrt, current + part, parts + 1)) {
                    return true;
                }
            }

            power *= 10;
        }

        return false;
    }

    private static boolean is_BT(long number, long sqrt) {
        return BTHelper(number, sqrt, 0, 0);
    }

    public static boolean is_S_number(long number) {
        long sqrt = (long) Math.sqrt(number);
        if (sqrt * sqrt != number)
            return false;
        return is_BT(number, sqrt);
    }

    public static void main(String[] args) {

        long sum = 0;

        for (long num = 2; num <= 1000000; num++) {
            long square = num * num;

            if (is_S_number(square))
                sum += square;
        }

        System.out.println(sum);
    }
}