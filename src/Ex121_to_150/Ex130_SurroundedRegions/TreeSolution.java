package Ex121_to_150.Ex130_SurroundedRegions;

/**
 * 四条边上的o都不会被x包围, 所以需要保留,
 * 但同时需要将其expand, 与其相连的位置也认为是不被x包围的
 */
public class TreeSolution {

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        // 1. loop from left to right, check and expand first & last row
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }
        // 2. loop from top to bottom, check and expand first & last column
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }
        // 3. go all the board, and set A to O, O to X (Cause the O left, must be surrounded by X)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        // if go outside of the board, or it's not connected to any 'O', stop dfs
        if (row < 0 || row > board.length - 1
                || col < 0 || col > board[0].length - 1
                || board[row][col] != 'O') {
            return;
        }
        // it must not surround by 'X', mark it as A
        board[row][col] = 'A';
        // go all 4 sides to keep dfs
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }

    public static void main(String[] args) {
        TreeSolution ts = new TreeSolution();
//        char[][] test = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] test = new char[][]{{'O'}};
        ts.solve(test);
        for (char[] chars : test) {
            for (char aChar : chars) {
                System.out.printf(aChar + " ");
            }
            System.out.println();
        }
    }

}
