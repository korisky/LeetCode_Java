package Ex1_300.Ex61_to_90.Ex79_WordSearch;

public class BackTrackingSol {


    /**
     * 尝试使用Backtracking递归+回退来进行查询, backTracking的核心是需要修改已经走过的路不可以再走
     */
    public static boolean exist(char[][] board, String word) {
        return dfsBackTracking(board, 0, 0, word.toCharArray(), 0);
    }

    public static boolean dfsBackTracking(char[][] board, int r, int c, char[] word, int idx) {

        // 全部匹配成功
        if (idx == word.length) {
            return true;
        }

        // 越界或者不同不再查询
        if (r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1 || board[r][c] != word[idx]) {
            return false;
        }

        // backTrack 核心, 需要记录/修改已经visited的部分
        char tmp = board[r][c];
        board[r][c] = '*';

        // 上下左右尝试进行匹配
        boolean found = dfsBackTracking(board, r - 1, c, word, idx + 1)
                || dfsBackTracking(board, r + 1, c, word, idx + 1)
                || dfsBackTracking(board, r, c - 1, word, idx + 1)
                || dfsBackTracking(board, r, c + 1, word, idx + 1);

        // backTrack核心, 该次搜素后修改回去
        board[r][c] = tmp;
        return found;
    }


    public static void main(String[] args) {

        char[] row1 = new char[]{'A', 'B', 'C', 'E'};
        char[] row2 = new char[]{'S', 'F', 'C', 'S'};
        char[] row3 = new char[]{'A', 'D', 'E', 'E'};

        char[][] test = new char[3][4];
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        System.out.println(exist(test, "ABCB"));
        System.out.println(exist(test, "ABCC"));
        System.out.println(exist(test, "ABFDA"));
    }
}
