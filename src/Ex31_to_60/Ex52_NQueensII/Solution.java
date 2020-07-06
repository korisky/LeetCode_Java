package Ex31_to_60.Ex52_NQueensII;

public class Solution {

    private int result;

    public int totalNQueens(int n) {
        result = 0;
        helper(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return result;
    }

    private void helper(int boardLen, int row, boolean[] cols, boolean[] diagLeft2Right,
                        boolean[] diagRight2Left) {
        if (row == boardLen) {
            result++;
        } else {
            for (int col = 0; col < boardLen; col++) {
                int dLeft = row - col + boardLen;
                int dRight = row + col;
                if (!cols[col] && !diagLeft2Right[dLeft] && !diagRight2Left[dRight]) { // if it's valid
                    cols[col] = diagLeft2Right[dLeft] = diagRight2Left[dRight] = true;
                    helper(boardLen, row + 1, cols, diagLeft2Right,diagRight2Left);
                    cols[col] = diagLeft2Right[dLeft] = diagRight2Left[dRight] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.totalNQueens(3));
    }
}
