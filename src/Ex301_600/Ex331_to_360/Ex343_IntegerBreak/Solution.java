package Ex301_600.Ex331_to_360.Ex343_IntegerBreak;

public class Solution {

    /**
     * 题目期望通过拆分n为多段整数, 使得整数相乘得到最大值, 这里需要考虑动态规划
     * Dp(5) = Max(1x5, Dp(1) + Dp(4), Dp(2) + Dp(3))
     * 可以看出, 我们目标整数为5的情况, 可以拆分为2大类
     * 1) 如果1x5就是最大的, 那么不拆了, 这个就是5
     * 2) 如果拆, 则可以拆分为1+4, 或者2+3, 实际上就是取其中最大的一个来看, Dp(1) or 1 x Dp(4) or 4, Dp(2) or 2 x Dp(3) or 3 -> 4 或 6
     * 对1和2进行取Max, 即为当前这个Dp最大得到的乘法分段, 进一步提取j为for循环部分, 即得到公式
     * Math.max(j, dp[j]) x Math.max(i - j, dp[i-j])
     * 以上面的例子, dp[5] = dp[5] 或 ( max(dp[1], 1) x max(dp[5-1], 5-1) )
     * 而每次都跟dp[i]进行对比, 是因为j是内层循环, 可能不同大小的j已经出来过最大的值了
     */
    public int integerBreak(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 动态规划核心
                dp[i] = Math.max(
                        dp[i],
                        Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
