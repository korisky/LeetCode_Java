package Ex1_300.Ex31_to_60.Ex36_ValidSudoku;

/*
Just simply use 9*9 2-d arrays to store row & col & box's numbers that we met
 */

public class isValidSudoku_S {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxs = new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int curNum = board[r][c] - '1';
                    int boxIndex = 3 * (r / 3) + (c / 3);
                    if (rows[r][curNum] > 0 || cols[c][curNum] > 0 || boxs[boxIndex][curNum] > 0)
                        return false;
                    else {
                        rows[r][curNum]++;
                        cols[c][curNum]++;
                        boxs[boxIndex][curNum]++;
                    }
                }
            }
        }
        return true;
    }
}
