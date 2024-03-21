package Ex1_300.Ex181_to_210.Ex198_HouseRobber;

public class Solution {

    /**
     * 与在无序数组中找到子序列构成的和最大题目类似, 不允许相邻
     * 因为是rob, 所以也算是一种greedy, rob越多越好
     * 动态规划: dp
     */
    public int rob(int[] nums) {

        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 与最大求和不同, 题目中num一定>0, 所以初始化不同
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
