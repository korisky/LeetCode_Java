package Ex301_600.Ex416_PartitionEqualSubsetSum;

public class Solution {

    /**
     * 问题的隐性核心在与, 得到2组和相同的分组, 这个和就是所有元素累加/2,
     * 就变成了知道target找分配方法的问题, 但这个问题也是由很多小问题组成, 所以需要考虑使用DP
     */
    public static boolean canPartition(int[] nums) {

        // 1. 如果元素相加总和不是偶数, 那么一定不可能切分得开2组相同大小的
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        // 2. 需要考虑dp进行处理, 特殊点在于, 这里的column变成了sum
        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                // 我们需要对比的是, 当前j是否与num[i-1]相同
                if (nums[i - 1] == j || j == 0) {
                    dp[i][j] = true;
                } else if (nums[i - 1] > j) {
                    // 大于j, 则跳过该值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // nums[i-1] < j, 考虑是否使用当前值, 但是2个都来自于i-1
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(canPartition(new int[]{1, 2, 3, 6}));
    }
}
