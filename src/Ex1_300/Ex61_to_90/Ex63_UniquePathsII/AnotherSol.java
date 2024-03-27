package Ex1_300.Ex61_to_90.Ex63_UniquePathsII;

public class AnotherSol {

    /**
     * 动态规划入门, 但这一题与后续64区别较大, 这个版本是求方法数量
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (null == obstacleGrid || obstacleGrid[0][0] == 1) return 0;

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        // 需要初始化第一行
        for (int c = 1; c < m; c++) {
            if (obstacleGrid[0][c] == 0 && dp[0][c - 1] == 1) {
                dp[0][c] = 1;
            }
        }

        // 初始化第一列
        for (int r = 1; r < n; r++) {
            if (obstacleGrid[r][0] == 0 && dp[r - 1][0] == 1) {
                dp[r][0] = 1;
            }
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                // 如果当前已经可以走, 则累加可达方式
                if (obstacleGrid[r][c] == 0) {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * 不使用额外array的方式 (因为不会重复遍历)
     */
    public static int uniquePathsWithObstacles_WithoutDpArray(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid[0][0] == 1) return 0;

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;

        // 初始化第一列
        for (int c = 1; c < m; c++) {
            // 如果当前不是obstacle, 并且能从左边来, 那么可以到达的way就是1
            if (obstacleGrid[0][c] == 0 && obstacleGrid[0][c - 1] == 1) {
                obstacleGrid[0][c] = 1;
            }
        }

        // 初始化第一行
        for (int r = 1; r < n; r++) {
            // 如果当前不是obstacle, 并且能从上边来, 那么可以到达的way就是1
            if (obstacleGrid[r][0] == 0 && obstacleGrid[r - 1][0] == 1) {
                obstacleGrid[r][0] = 1;
            }
        }

        // 进行dp遍历
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (obstacleGrid[r][c] == 0) {
                    // 如果当前没有阻碍, 那么到达该位置的way, 是从上方和左侧, 两个方向的ways的叠加
                    obstacleGrid[r][c] = obstacleGrid[r - 1][c] + obstacleGrid[r][c - 1];
                } else {
                    // 这里需要注意, 一定有阻碍, 需要手动将其置0
                    obstacleGrid[r][c] = 0;
                }
            }
        }
        // 最后抵达的部分就是总ways
        return obstacleGrid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles_WithoutDpArray(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
