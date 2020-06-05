package Ex63_UniquePathsII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int colLen = obstacleGrid[0].length;
        int[] dp = new int[colLen];
        dp[0] = 1; // start point must be reached
        for (int[] row : obstacleGrid) {
            for (int col = 0; col < colLen; col++){
                if (row[col] == 1)
                    dp[col] = 0;
                else if(col > 0)
                    dp[col] += dp[col - 1];
            }
        }
        return dp[colLen - 1];
    }
}
