import java.util.*;

public class cryptArithmatic {

    // to store the valid answers
    static int ans = 0;

    private static int findNum(String word, Map<Character, Integer> charNumber) {
        int num = 0;
        for (char ch : word.toCharArray()) {
            num = num * 10 + charNumber.get(ch);
        }
        return num;
    }

    private static boolean check(String[] input, Map<Character, Integer> charNumber) {
        int numSum, sum, len;
        sum = 0;
        numSum = 0;
        len = input.length;
        for (int str = 0; str < len - 1; str++) {
            numSum += findNum(input[str], charNumber);
        }
        sum = findNum(input[len - 1], charNumber);
        if (numSum != sum)
            return false;

        int index = input[len - 1].length() - 1;
        while (sum != 0) {
            int val = sum % 10;
            for (Character c : charNumber.keySet()) {
                if (val == charNumber.get(c)) {
                    if (c == input[len - 1].charAt(index)) {
                        index--;
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            sum /= 10;
        }
        return true;
    }

    // private static boolean check(String[] input, Map<Character, Integer>
    // charNumber) {
    // int num1, num2, num3;
    // num1 = num2 = num3 = 0;
    // for (char ch : input[0].toCharArray())
    // num1 = num1 * 10 + charNumber.get(ch);
    // for (char ch : input[1].toCharArray())
    // num2 = num2 * 10 + charNumber.get(ch);
    // for (char ch : input[2].toCharArray())
    // num3 = num3 * 10 + charNumber.get(ch);

    // if (num1 + num2 != num3)
    // return false;
    // int index = input[2].toCharArray().length - 1;
    // while (num3 != 0) {
    // int val = num3 % 10;
    // for (Character c : charNumber.keySet()) {
    // if (val == charNumber.get(c)) {
    // if (c == input[2].charAt(index)) {
    // index--;
    // continue;
    // } else {
    // return false;
    // }
    // }
    // }
    // num3 /= 10;
    // }
    // return true;
    // }

    private static void cryptHelper(String[] input, Set<Character> firstCharacters, Map<Character, Integer> charNumber,
            boolean[] isAssigned, int filled) {
        // check
        if (filled == charNumber.size()) {
            if (check(input, charNumber)) {
                ans++;
                System.out.println("Solved");
                for (int i = 0; i < input.length; i++) {
                    String word = input[i];
                    if (i < input.length - 1 && input[2].length() > input[0].length())
                        System.out.printf("  ");
                    for (char ch : word.toCharArray()) {
                        System.out.printf("%d ", charNumber.get(ch));
                    }

                    System.out.println();
                }
            }
            return;
        }

        // constraints
        for (Character c : charNumber.keySet()) {
            if (charNumber.get(c) == -1) {
                int startDigit = firstCharacters.contains(c) ? 1 : 0;
                for (int i = startDigit; i <= 9; i++) {
                    if (!isAssigned[i]) {
                        charNumber.put(c, i);
                        isAssigned[i] = true;
                        cryptHelper(input, firstCharacters, charNumber, isAssigned, filled + 1);
                        charNumber.put(c, -1);
                        isAssigned[i] = false;
                    }
                }
                return;
            }
        }

    }

    public static void solveCrypt(String[] input) {
        // arm-length -> trivial case / validation
        Set<Character> uniq = new HashSet<>();
        for (String s : input)
            for (char c : s.toCharArray())
                uniq.add(c);

        if (uniq.size() > 10)
            return;

        // environment
        boolean[] isAssigned = new boolean[10];
        Set<Character> firstCharacters = new HashSet<>();
        Map<Character, Integer> charNumber = new HashMap<>();

        // taking first characters
        for (String s : input)
            firstCharacters.add(s.charAt(0));

        // filling the array with -1 value
        for (String s : input)
            for (char ch : s.toCharArray())
                charNumber.put(ch, -1);

        // to know how many were filled
        int filled = 0;

        // call helper
        cryptHelper(input, firstCharacters, charNumber, isAssigned, filled);
    }

    public static void main(String[] args) {
        // String[] input = { "SEND", "MORE", "MONEY" }; //passed
        // String[] input = { "GREEN", "BLUE", "BLACK" }; //passed
        // String[] input = { "CHOO", "CHOO", "TRAIN" }; //passed
        // String[] input = { "BASE", "BALL", "GAMES" }; //passed
        // String[] input = { "DONALD","GERALD","ROBERT" };//passed
        String[] input = { "KAYAK", "KAYAK", "KAYAK", "KAYAK", "KAYAK", "KAYAK", "SPORT" };
        solveCrypt(input);
        System.out.println(ans);
    }
}

/*
 * ALFA + BETA + GAMA = DELTA =>
 * https://www.mathsisfun.com/puzzles/alfa-beta-gama-delta.html
 * 
 * CHOO
 * + CHOO
 * ------
 * TRAIN => https://www.mathsisfun.com/puzzles/choo-choo.html
 * 
 * KAYAK
 * KAYAK
 * KAYAK
 * KAYAK
 * KAYAK
 * KAYAK
 * -----
 * SPORT => https://www.mathsisfun.com/puzzles/kayak.html
 * 
 * 
 * MOST
 * +MOST
 * -----
 * TOKYO => https://www.mathsisfun.com/puzzles/most-most.html
 * 
 */