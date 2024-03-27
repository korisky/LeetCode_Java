package Ex1_300.Ex61_to_90.Ex64_MinimumPathSum;

public class AnotherSol {

    /**
     * 使用额外的1纬dp数组的方法
     */
    public int minPathSum(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int[] dp = new int[c];

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                // 在最后一行但不是最后一列, 只能从右边填入
                if (i == r - 1 && j != c - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                    continue;
                }
                // 在最后一列, 但不是最后一行, 只能从下方填入
                if (i != r - 1 && j == c - 1) {
                    dp[j] = grid[i][j] + dp[j];
                    continue;
                }
                // 不是最后一行, 也不是最后一列
                if (i != r - 1 && j != c - 1) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                    continue;
                }
                // 最后的情况, 也是初始化的情况
                dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }

    /**
     * 修改原数组的不需要额外空间的方法
     */
    public int minPathSum_NoExtraSpace(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                // 在最后一行但不是最后一列, 只能从右边填入
                if (i == r - 1 && j != c - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                    continue;
                }
                // 在最后一列, 但不是最后一行, 只能从下方填入
                if (i != r - 1 && j == c - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                    continue;
                }
                // 不是最后一行, 也不是最后一列
                if (i != r - 1 && j != c - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                    continue;
                }
                // 最后的情况, 也是初始化的情况
                grid[i][j] = grid[i][j];
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        AnotherSol use = new AnotherSol();
        int[] row1 = new int[]{1, 3, 1};
        int[] row2 = new int[]{1, 5, 1};
        int[] row3 = new int[]{4, 2, 1};
        int[][] test = new int[3][];
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        System.out.println(use.minPathSum(test));
        System.out.println(use.minPathSum_NoExtraSpace(test));
    }
}
