package Ex1_300.Ex61_to_90.Ex79_WordSearch;

/*
    board =
    [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
                            ]
    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.
 */


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean exist(char[][] board, String word) {
        List<int[]> startPoint = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0) && dfsHelper(board, r, c, word.toCharArray(), 0) )
                    return true;
            }
        }
        return false;
    }

    public boolean dfsHelper(char[][] board, int curRow, int curCol, char[] wordChars, int curChar) {
        if (curChar == wordChars.length)
            return true;

        if (curRow < 0 || curRow > board.length - 1
                || curCol < 0 || curCol > board[0].length - 1
                || wordChars[curChar] != board[curRow][curCol])
            return false;

        board[curRow][curCol] = '*';
        boolean exist = dfsHelper(board, curRow + 1, curCol, wordChars, curChar + 1) ||
                dfsHelper(board, curRow - 1, curCol, wordChars, curChar + 1) ||
                dfsHelper(board, curRow, curCol + 1, wordChars, curChar + 1) ||
                dfsHelper(board, curRow, curCol - 1, wordChars, curChar + 1);
        board[curRow][curCol] = wordChars[curChar];
        return exist;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        char[] row1 = new char[]{'A', 'B', 'C', 'E'};
        char[] row2 = new char[]{'S', 'F', 'C', 'S'};
        char[] row3 = new char[]{'A', 'D', 'E', 'E'};

        char[][] test = new char[3][4];
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        System.out.println(use.exist(test, "ABCB"));
    }
}
