package Ex301_600.Ex451_to_480.Ex463_IslandPerimeter;

public class Solution {

    /**
     * 题目需要统计island的海滩的大小（边缘）, 这里的核心是只要遇到了都+4（所有边）,
     * 然后再进行确认左边和上边, 如果有连着都是island的, 都需要-2, 这样来进行确认
     */
    public int islandPerimeter(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int result = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    result += 4;

                    if (r > 0 && grid[r - 1][c] == 1) {
                        result -= 2;
                    }
                    if (c > 0 && grid[r][c - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}
