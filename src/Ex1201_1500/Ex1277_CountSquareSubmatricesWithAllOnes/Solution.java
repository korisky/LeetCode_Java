package Ex1201_1500.Ex1277_CountSquareSubmatricesWithAllOnes;

public class Solution {

    /**
     * Ex1277 目标是找到所有包含1的正方形, 典型的dp问题
     * 由于每一个正方形包含的内部, 一定已经符合正方形, 所以需要进行一个记录进行拓展
     */
    public int countSquares(int[][] matrix) {

        int ans = 0;

        // dimension
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        // init first column, if val == 1, then it's already a len = 1 square, could extend to bigger one
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }

        // init first row, watch out, we should not initialize the[0][0] again, start with 1
        for (int j = 1; j < m; j++) {
            dp[0][j] = matrix[0][j];
            ans += dp[0][j];
        }

        // traversing
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // if it could be extended
                if (matrix[i][j] == 1) {
                    // it could be extended, it the left, the upper, and the left-diagonal, are all 1s (no 1, no extend)
                    dp[i][j] = 1 + Math.min(
                            Math.min(dp[i][j - 1], dp[i - 1][j]),
                            dp[i - 1][j - 1]);
                }
                ans += dp[i][j];
            }
        }

        return ans;
    }
}
