import java.util.Scanner;

public class nQueen {

    // checker slave
    private static boolean isSafe(int[] queenPos, int row, int col) {
        // ?check upper left diagnal
        for (int leftUpRow = row - 1, leftUpCol = col - 1; leftUpRow >= 0 && leftUpCol >= 0; leftUpCol--, leftUpRow--) {
            if (queenPos[leftUpRow] == leftUpCol)
                return false;
        }

        // ?check up side
        for (int UpRow = row - 1; UpRow >= 0; UpRow--) {
            if (queenPos[UpRow] == col)
                return false;
        }

        // ?check upper right diagnal
        for (int rightUpRow = row - 1, rightUpCol = col + 1; rightUpRow >= 0
                && rightUpCol < queenPos.length; rightUpCol++, rightUpRow--) {
            if (queenPos[rightUpRow] == rightUpCol)
                return false;
        }

        return true;
    }

    // helper
    private static void nqHelper(int numberOfQueens, int[] queenPos, int currQueen) {
        // check
        if (currQueen == numberOfQueens) {
            System.out.println("Solved!!!");
            for (int ro = 0; ro < numberOfQueens; ro++, System.out.println()) {
                for (int co = 0; co < numberOfQueens; co++) {
                    if (queenPos[ro] == co)
                        System.out.print(" Q ");
                    else
                        System.out.print(" * ");
                }
            }
            for (int i = 0; i < Integer.MAX_VALUE; i++)
                ;
            return;
        }

        // enumerate
        int row;
        int col;
        row = currQueen;

        // choose & constraints
        for (col = 0; col < numberOfQueens; col++) {
            if (isSafe(queenPos, row, col)) {
                queenPos[currQueen] = col; // DO
                nqHelper(numberOfQueens, queenPos, currQueen + 1);// Process
                queenPos[currQueen] = -1; // UNDO
            }
        }
    }

    // wrappper
    public static void NQueen(int numberOfQueens) {
        // arm-length - validation & trivial cases
        if (numberOfQueens < 4)
            return;

        // environment
        int[] queenPos = new int[numberOfQueens]; // ! to store the queen positions
        for (int pos = 0; pos < numberOfQueens; pos++)
            queenPos[pos] = -1; // ? initially there are no queens on the chess board

        // helper call - pass environment , initiate
        nqHelper(numberOfQueens, queenPos, 0);
    }

    public static void main(String[] args) {
        Scanner kbrd = new Scanner(System.in);
        int numberOfQueens = kbrd.nextInt();
        NQueen(numberOfQueens);
        kbrd.close();
    }
}