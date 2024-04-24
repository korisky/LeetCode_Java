package Ex2436_MinimumSplitGCD;

public class Solution {


    /**
     * 题目希望划分多个连续的子序列, 按照每个序列中最大公约数GCD>1的情况来划分
     */
    public static int minimumSplits(int[] nums) {
        int res = 1, x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x = gcd(x, nums[i]);
            if (x < 2) {
                x = nums[i];
                res++;
            }
        }
        return res;
    }

    /**
     * 最大公约数的公式, 辗转相除法
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
