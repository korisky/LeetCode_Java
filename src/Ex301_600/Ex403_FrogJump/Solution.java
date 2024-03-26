package Ex301_600.Ex403_FrogJump;

public class Solution {

    /**
     * 动态规划, 给出的stones是石头的位置, 可以看作连续的 0->n 的河上
     */
    public boolean canCross(int[] stones) {

        // dp的行列, 行是指石头, 列是指跳跃的步长, 步长是不会超过最大石头的值的
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        // 遍历方式不同, 石头是从左到右, 但是每一次需要查找能不能从前面跳回来
        // 所以j需要反向查找, 能不能从哪一个石头过来
        for (int i = 1; i <= stones.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 确认步长
                int stepSize = stones[i] - stones[j];
                if (stepSize > j + 1) {
                    // j 是跳到上一个石头所用的stepSize, 如果都超过了+1, 可以过滤该情况了
                    break;
                }
                // 题目提示, 当前石头可以被跳到, 取决于上一个跳到的石头, 其中一个stepSize是可以的
                dp[i][stepSize] = dp[j][stepSize - 1] || dp[j][stepSize] || dp[j][stepSize + 1];
                // 快速返回结果, 如果当前i已经是最后一个石头, 并且可以被跳到, 返回
                if (i == n - 1 && dp[i][stepSize]) {
                    return true;
                }
            }
        }

        return false;
    }
}
