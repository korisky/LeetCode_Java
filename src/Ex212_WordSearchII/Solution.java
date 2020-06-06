package Ex212_WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
    Too slow if we just keep searching on each specific slot and try out all candidate words
 */

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> result = new HashSet<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                for (String word : words) {
                    if (board[r][c] == word.charAt(0) && dfsHelper(board, r, c, word.toCharArray(), 0))
                        result.add(word);
                }
            }
        }
        return new ArrayList<>(result);
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
}
