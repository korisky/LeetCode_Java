package Ex301_600.Ex481_to_510.Ex494_TargetSum;

import java.util.Arrays;

public class TwoD_DPSolution {

    /**
     * 使用动态规划
     */
    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * totalSum + 1];

        // init first row of dp table
        dp[0][nums[0] + totalSum] = 1;
        dp[0][-nums[0] + totalSum] += 1;

        // fill dp table
        for (int idx = 1; idx < nums.length; idx++) {
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[idx - 1][sum + totalSum] > 0) {
                    dp[idx][sum + nums[idx] + totalSum] += dp[idx - 1][sum + totalSum];
                    dp[idx][sum - nums[idx] + totalSum] += dp[idx - 1][sum + totalSum];
                }
            }
        }

        // valid range
        return Math.abs(target) > totalSum
                ? 0
                : dp[nums.length - 1][target + totalSum];
    }
}
