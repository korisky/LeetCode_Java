package Extras.DynamicProgramming;

public class Packaging {

    /**
     * 动态规划 - 背包问题
     *
     * @param weight  物品重量
     * @param value   物品单价
     * @param bagSize 背包容量
     */
    public int wightBagProblem(int[] weight, int[] value, int bagSize) {
        // 物品数量
        int goods = weight.length;
        // dp 保存
        int[][] dp = new int[goods + 1][bagSize + 1];
        // 遍历对比
        for (int i = 1; i <= goods; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (weight[i - 1] > j) {
                    // 当前物品重量 > 背包容量, 只能延续前一个的值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 可以装入容量, 取更大的那个
                    dp[i][j] = Math.max(
                            dp[i - 1][j], // 要么还是维持
                            value[i - 1] + dp[i - 1][j - weight[i - 1]]); // 要么取当前value, 并获取剩余容量下的最大value
                }
            }
        }
        // 最后即最大值
        return dp[goods][bagSize];
    }
}
