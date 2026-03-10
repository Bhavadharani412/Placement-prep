import java.util.*;

public class CryptarithmSolver {

    public int solution(String[] crypt) {

        // ---------------------------------------------------------
        // STEP 1 : Extract the three words
        // crypt[0] + crypt[1] = crypt[2]
        // ---------------------------------------------------------
        String word1 = crypt[0];
        String word2 = crypt[1];
        String word3 = crypt[2];

        // ---------------------------------------------------------
        // STEP 2 : Collect all unique letters from the words
        // Example:
        // SEND + MORE = MONEY
        // Unique letters → {S,E,N,D,M,O,R,Y}
        // ---------------------------------------------------------
        Set<Character> unique = new HashSet<>();

        for (String word : crypt) {
            for (char c : word.toCharArray()) {
                unique.add(c);
            }
        }

        // If more than 10 unique letters → impossible
        // because digits available = 0–9 (10 digits)
        if (unique.size() > 10)
            return 0;

        // Convert set to list so we can access letters by index
        List<Character> letters = new ArrayList<>(unique);

        // ---------------------------------------------------------
        // STEP 3 : Create mapping structure
        // map[letter] = digit assigned to that letter
        // Example:
        // map['S'-'A'] = 9 means S → 9
        // ---------------------------------------------------------
        int[] map = new int[26];
        Arrays.fill(map, -1); // -1 means not assigned yet

        // ---------------------------------------------------------
        // STEP 4 : Track which digits are already used
        // used[d] = true means digit d already assigned to a letter
        // ---------------------------------------------------------
        boolean[] used = new boolean[10];

        // ---------------------------------------------------------
        // STEP 5 : Leading letters cannot be zero
        // Example:
        // SEND → S cannot be 0
        // MORE → M cannot be 0
        // MONEY → M cannot be 0
        // ---------------------------------------------------------
        boolean[] nonZero = new boolean[26];

        if (word1.length() > 1)
            nonZero[word1.charAt(0) - 'A'] = true;

        if (word2.length() > 1)
            nonZero[word2.charAt(0) - 'A'] = true;

        if (word3.length() > 1)
            nonZero[word3.charAt(0) - 'A'] = true;

        // ---------------------------------------------------------
        // STEP 6 : Start DFS (Backtracking)
        // ---------------------------------------------------------
        return dfs(0, letters, map, used, nonZero, word1, word2, word3);
    }

    private int dfs(int pos,
                    List<Character> letters,
                    int[] map,
                    boolean[] used,
                    boolean[] nonZero,
                    String w1, String w2, String w3) {

        /*
        ------------------------------------------------------------
        DFS EXPLANATION

        pos = which letter we are assigning a digit to

        Example:
        letters = [S,E,N,D,M,O,R,Y]

        pos=0 → assign digit to S
        pos=1 → assign digit to E
        pos=2 → assign digit to N
        ...

        The recursion builds assignments like a tree:

        S=1
           E=0
              N=2
                 D=3
                 ...
        ------------------------------------------------------------
        */

        // ---------------------------------------------------------
        // BASE CASE : all letters assigned digits
        // ---------------------------------------------------------
        if (pos == letters.size()) {

            // Now verify if the equation is correct
            // Example: SEND + MORE = MONEY
            if (check(w1, w2, w3, map))
                return 1;   // valid solution
            else
                return 0;   // invalid assignment
        }

        int count = 0;

        // Current letter we want to assign a digit to
        char letter = letters.get(pos);

        // ---------------------------------------------------------
        // Try every digit from 0 to 9
        // ---------------------------------------------------------
        for (int digit = 0; digit <= 9; digit++) {

            // Skip if digit already used by another letter
            if (used[digit])
                continue;

            // If this letter is a leading letter,
            // it cannot be assigned digit 0
            if (digit == 0 && nonZero[letter - 'A'])
                continue;

            // -----------------------------------------------------
            // Assign digit to letter
            // -----------------------------------------------------
            used[digit] = true;
            map[letter - 'A'] = digit;

            /*
            Example partial assignment:

            S = 1
            E = 0
            N = 2
            ...
            */

            // Recursively assign next letter
            count += dfs(pos + 1, letters, map, used, nonZero, w1, w2, w3);

            // -----------------------------------------------------
            // BACKTRACK
            // remove assignment and try next digit
            // -----------------------------------------------------
            used[digit] = false;
            map[letter - 'A'] = -1;
        }

        return count;
    }

    private boolean check(String w1, String w2, String w3, int[] map) {

        /*
        ------------------------------------------------------------
        CHECK FUNCTION EXPLANATION

        Instead of converting whole words into large numbers
        (which can overflow), we simulate column addition.

        Example:

            SEND
          + MORE
          -------
           MONEY

        We check addition from RIGHT to LEFT.
        ------------------------------------------------------------
        */

        int carry = 0;

        int i = w1.length() - 1; // pointer for word1
        int j = w2.length() - 1; // pointer for word2
        int k = w3.length() - 1; // pointer for result

        while (i >= 0 || j >= 0 || k >= 0) {

            /*
            Extract digit corresponding to each letter
            If word shorter → treat digit as 0
            */

            int d1 = (i >= 0) ? map[w1.charAt(i) - 'A'] : 0;
            int d2 = (j >= 0) ? map[w2.charAt(j) - 'A'] : 0;
            int d3 = (k >= 0) ? map[w3.charAt(k) - 'A'] : 0;

            // Perform column addition
            int sum = d1 + d2 + carry;

            /*
            Example:

            D + E = Y

            If D=7 and E=5

            7 + 5 = 12
            result digit = 2
            carry = 1
            */

            // Check if result digit matches
            if (sum % 10 != d3)
                return false;

            // Update carry
            carry = sum / 10;

            // Move to next column
            i--;
            j--;
            k--;
        }

        // After all columns processed
        // equation valid only if no leftover carry
        return carry == 0;
    }

    // -------------------------------------------------------------
    // Example run
    // -------------------------------------------------------------
    public static void main(String[] args) {

        CryptarithmSolver solver = new CryptarithmSolver();

        String[] crypt1 = {"SEND", "MORE", "MONEY"};
        String[] crypt2 = {"GREEN", "BLUE", "BLACK"};
        String[] crypt3 = {"ONE", "TWO", "THREE"};
	String[] crypt4 = {"CP", "IS", "FUN"};

        System.out.println(solver.solution(crypt1)); // 1
        System.out.println(solver.solution(crypt2)); // 12
        System.out.println(solver.solution(crypt3)); // 0
	System.out.println(solver.solution(crypt4));
    }
}