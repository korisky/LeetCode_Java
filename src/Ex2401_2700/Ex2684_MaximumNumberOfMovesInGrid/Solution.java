package Ex2401_2700.Ex2684_MaximumNumberOfMovesInGrid;

public class Solution {

    public int maxMoves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        int max = 1;
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i > 1 && j > 1) {
                    if (grid[i - 1][j] < grid[i][j]) {
                        dp[i][j] = 1 + grid[i - 1][j];
                    }
                    if (grid[i][j - 1] < grid[i][j]) {
                        dp[i][j] = 1 + grid[i - 1][j];
                    }
                    if (grid[i - 1][j - 1] < grid[i][j]) {
                        dp[i][j] = 1 + grid[i - 1][j];
                    }
                }

            }
        }


        return 0;
    }
}
