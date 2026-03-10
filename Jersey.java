import java.util.*;

public class Jersey {
    private static boolean allTrue(boolean[] arr) {
        for (boolean n : arr)
            if (!n)
                return false;
        return true;
    }

    private static int gcd(int u, int v) {
        if (u == 0)
            return v;
        return gcd(v % u, u);
    }

    private static int lcm(int u, int v) {
        return (u / gcd(u, v)) * v;
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 1, 4, 6, 3, 5 };
        int[] arr = { 6, 13, 2, 8, 10, 5, 7, 1, 15, 3, 11, 14, 9, 12, 4 };

        boolean[] came = new boolean[arr.length];
        // List<Integer> list = new ArrayList<>();
        int curEle = 1;
        int ans = 1;
        while (!allTrue(came)) {
            int nxtind = arr[curEle - 1];
            int steps = 1;
            while (nxtind != curEle) {
                steps++;
                nxtind = arr[nxtind - 1];
            }
            ans = lcm(ans, steps);
            // System.out.println(ans);
            // list.add(steps);
            came[curEle - 1] = true;
            curEle++;
        }
        System.out.println(ans);
        // for(int i=0;i<arr.length;i++)
        // System.out.print(list.get(i)+" ");
    }
}