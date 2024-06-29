package Ex2101_2400.Ex2373_LargestLocalValuesInMatrix;

public class Solution {

    /**
     * 没有DP的方式, 直接brut force实现
     */
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = findMax(grid, i, j);
            }
        }
        return maxLocal;
    }

    /**
     * 寻找3x3矩阵内的最大值
     */
    private int findMax(int[][] grid, int x, int y) {
        int maxEle = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                maxEle = Math.max(maxEle, grid[i][j]);
            }
        }
        return maxEle;
    }
}
