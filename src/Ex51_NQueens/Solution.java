package Ex51_NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Idea from LeetCode:
        It's quite easy to check whether a row or column is already have a Queen,
        But it's hard to check the Diagonal Direction.

        We can use two 1-d boolean array to represent Diagonal:

        e.g. (0, 0), (0, 1), (0, 2), (0, 3)
             (1, 0), (1, 1), (1, 2), (1, 3)
             (2, 0), (2, 1), (2, 2), (2, 3)
             (3, 0), (3, 1), (3, 2), (3, 3)

        In this 4x4 array, if we focusing on (1, 2), we could find out some patterns:
            1. Focusing on top-left to bottom-right diagonal, (0, 1), (1, 2), (2, 3),
                they all meet: (row - col) = -1. If we add a big enough positive
                number (e.g. row's length), then we could store it into an 1-d array,
                each time we can just calculate (row - col) + Pos, then can check current
                slot is valid or not.
                Next, we need to think about how large we need for storing all diagonal,
                that would be 2 * row length - 1, we can just use 2 * row length.

                The top-right to bottom-left diagonal is quite similar, we can find out
                (0, 3), (1, 2), (2, 1), (3, 0), meet: (row + col) = constant < row length

            2. The data flow would be: recursion get the row number, the traversing the column,
                if current slot's left and right diagonal is all VALID, then we set them TRUE
                and calling row + 1
 */

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n < 4)
            return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        helper(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new ArrayList<>(), result);
        return result;
    }

    private void helper(int boardLen, int row, boolean[] cols, boolean[] diagLeft2Right,
                        boolean[] diagRight2Left, List<String> board, List<List<String>> result) {

        if (row == boardLen) {
            result.add(new ArrayList<>(board)); // if all row's queens' position is set, add this solution
        } else {
            for (int col = 0; col < boardLen; col++) {
                int dLeft = row - col + boardLen;
                int dRight = row + col;
                if (!cols[col] && !diagLeft2Right[dLeft] && !diagRight2Left[dRight]) { // if it's valid
                    // create output
                    char[] rowAnswer = new char[boardLen];
                    Arrays.fill(rowAnswer, '.');
                    rowAnswer[col] = 'Q';
                    board.add(String.valueOf(rowAnswer));
                    // store it's info
                    cols[col] = diagLeft2Right[dLeft] = diagRight2Left[dRight] = true;
                    helper(boardLen, row + 1, cols, diagLeft2Right,
                            diagRight2Left, board, result); // recurrently call helper to find next row's solution
                    cols[col] = diagLeft2Right[dLeft] = diagRight2Left[dRight] = false;
                    board.remove(board.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.solveNQueens(4));
    }
}
