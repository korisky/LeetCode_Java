package Ex121_to_150.Ex130_SurroundedRegions;

/**
 * 其实每个slot都可以只遍历一次, 可以使用boolean数组来完成
 */
public class ImplSolution {

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        // store the visited
        boolean[][] visited = new boolean[board.length][board[0].length];
        // 1. loop from left to right, check and expand first & last row
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, visited, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, visited, board.length - 1, i);
            }
        }
        // 2. loop from top to bottom, check and expand first & last column
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, visited, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, visited, i, board[0].length - 1);
            }
        }
        // 3. go all the board, if slot has not been visited, it must be surrounded by X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int row, int col) {
        // if go outside of the board, or it's not connected to any 'O', stop dfs
        // plus: if we has already visited, we can also skip it
        if (row < 0 || row > board.length - 1
                || col < 0 || col > board[0].length - 1
                || board[row][col] != 'O'
                || visited[row][col]) {
            return;
        }
        // instead of marked it as A, we can just mark it has been visited
        visited[row][col] = true;
        // go all 4 sides to keep dfs
        dfs(board, visited, row - 1, col);
        dfs(board, visited, row + 1, col);
        dfs(board, visited, row, col - 1);
        dfs(board, visited, row, col + 1);
    }

    public static void main(String[] args) {
        ImplSolution ts = new ImplSolution();
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
