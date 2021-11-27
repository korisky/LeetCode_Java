package Ex200_NumberOfIslands;

public class DfsSolution {

    char[][] using = null;

    public int numIslands(char[][] grid) {
        using = grid.clone();
        int islandsNum = 0;
        for (int r = 0; r < using.length; r++) {
            for (int c = 0; c < using[0].length; c++) {
                if (using[r][c] == '1') {
                    // doing the sink and set all neighbor to 0
                    islandsNum += sink(r, c);
                }
            }
        }
        return islandsNum;
    }

    public int sink(int row, int col) {
        // for the cases we need to stop:
        // 1. index out of bound
        if (row < 0 || row >= using.length
                || col < 0 || col >= using[0].length) {
            return 0;
        }
        // 2. the current slot is water '0'
        if (using[row][col] == '0') {
            return 0;
        }
        // sink it
        using[row][col] = '0';
        // go left, right, upper, down
        sink(row + 1, col);
        sink(row - 1, col);
        sink(row, col + 1);
        sink(row, col - 1);
        return 1;
    }


}
