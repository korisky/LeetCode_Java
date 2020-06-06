package Ex64_MinimumPathSum;

import java.util.Arrays;

public class Solution {
    public int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        // 1-d dpnamic programming
        int[] dp = new int[colLen];
        dp[0] = grid[0][0];
        for (int c = 1; c < colLen; c++)
            dp[c] = dp[c - 1] + grid[0][c];

        for (int r = 1; r < rowLen; r++){
            dp[0] += grid[r][0];
            for (int c = 1; c < colLen; c++){
                dp[c] = Math.min(dp[c - 1], dp[c]) + grid[r][c];
            }
        }
        return dp[colLen - 1];

        // 2d dynamic programming
//        int[][] dp = new int[rowLen][colLen];
//        dp[0][0] = grid[0][0];
//
//        for (int c = 1; c < colLen; c++)
//            dp[0][c] = dp[0][c - 1] + grid[0][c];
//
//        for (int r = 1; r < rowLen; r++)
//            dp[r][0] += dp[r - 1][0] + grid[r][0];
//
//        for (int r = 1; r < rowLen; r++) {
//            for (int c = 1; c < colLen; c++) {
//                dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
//            }
//        }
//        return dp[rowLen - 1][colLen - 1];
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] row1 = new int[]{1, 3, 1};
        int[] row2 = new int[]{1, 5, 1};
        int[] row3 = new int[]{4, 2, 1};
        int[][] test = new int[3][];
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        System.out.println(use.minPathSum(test));
    }
}
