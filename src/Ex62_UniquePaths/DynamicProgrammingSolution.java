package Ex62_UniquePaths;

/*
    Because our terminate-slot is always the bottom-right corner,
    we do not have any 'barrier' to block our way.

    We can use dynamic programming to solve this problem
 */

public class DynamicProgrammingSolution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int r = 0; r < m; r++)
            dp[r][0] = 1; // it should always return 1 because the bot cannot turn left / up
        for (int c = 0; c < n; c++)
            dp[0][c] = 1;
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        DynamicProgrammingSolution use = new DynamicProgrammingSolution();
        System.out.println(use.uniquePaths(23, 10));
    }
}
