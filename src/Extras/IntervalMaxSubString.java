package Extras;

public class IntervalMaxSubString {

    /**
     * 在无序数组中找到子序列构成的和最大, 要求子序列中元素在原数组中两两不相邻
     * DP 动态规划
     */
    public static int findMaxSubArrWithInterval(int[] arr) {

        // conner cases
        if (arr == null) {
            return 0;
        }
        if (arr.length <= 1) {
            return arr[0];
        }

        // dp 初始化
        int[] dp = new int[arr.length];
        dp[0] = Math.max(0, arr[0]);
        dp[1] = Math.max(dp[0], arr[1]);

        // dp[i] 可以直接选择上一个 dp[i-1], 或 dp[i-2] + [当前遍历的元素]
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 10};
        System.out.println("Maximum sum of non-adjacent subsequence: " + findMaxSubArrWithInterval(nums));
        int[] nums2 = {3, 2, 5, 10, 7};
        System.out.println("Maximum sum of non-adjacent subsequence: " + findMaxSubArrWithInterval(nums2));

    }
}
