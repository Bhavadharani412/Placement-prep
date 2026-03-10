// import java.util.*;

public class PolyDevicible {

    private static void pd_helper(boolean[] used, int curVal, int curDig, int base) {
        // check
        if (curDig == base) {
            System.out.println(curVal);
            return;
        }

        // enumerate

        // constraint
        for (int i = 1; i <= 9; i++) {
            int newVal = curVal * 10 + i;
            if (used[i] == false && newVal % curDig == 0) {
                used[i] = true; // Do
                pd_helper(used, newVal, curDig + 1, base); // Process
                used[i] = false; // undo
            }
        }
    }

    public static void solve(int base) {
        // arm length - validation & trivial cases

        // set an environment
        boolean[] used = new boolean[base];

        // call helper - pass environment,initiate
        pd_helper(used, 0, 1, base);
    }

    public static void main(String[] args) {
        solve(10);
    }
}