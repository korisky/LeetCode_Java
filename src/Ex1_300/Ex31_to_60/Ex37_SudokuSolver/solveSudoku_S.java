package Ex1_300.Ex31_to_60.Ex37_SudokuSolver;


import java.util.ArrayList;
import java.util.List;

public class solveSudoku_S {

    // here is about: each row/col/box, each of the numbers from 1 to 9 is needed once
    // e.g. if rows[2][3] is true, means in row 3 we used number 4 already
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxs = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        List<int[]> emptySlots = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    rows[r][num] = true;
                    cols[c][num] = true;
                    boxs[(r / 3) * 3 + (c / 3)][num] = true;
                }
            }
        }
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int i, int j) {

        // Using recursion solving on left 2 right, up 2 down order
        if (i == board.length)
            return true;
        if (j == board[0].length)
            return solve(board, i + 1, 0);

        if (board[i][j] != '.')
            return solve(board, i, j + 1);

        int boxIndex = (i / 3) * 3 + (j / 3);
        for (int k = 0; k < 9; k++) {
            if (!rows[i][k] && !cols[j][k] && !boxs[boxIndex][k]) {
                rows[i][k] = cols[j][k] = boxs[boxIndex][k] = true;
                board[i][j] = (char) (k + '1');

                if (solve(board, i, j + 1))
                    return true;

                // If above criteria is not accepted, we need to "BACKTRACKING" to previous situation
                rows[i][k] = cols[j][k] = boxs[boxIndex][k] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }


    public static void main(String[] args) {
        solveSudoku_S use = new solveSudoku_S();
        char[][] test = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        use.solveSudoku(test);
    }
}
