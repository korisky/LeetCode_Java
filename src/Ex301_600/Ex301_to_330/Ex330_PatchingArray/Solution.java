package Ex301_600.Ex301_to_330.Ex330_PatchingArray;

public class Solution {
    /**
     * 题目目标是询问, 最少为nums添加多少个元素, 可以是的nums中的元素组合, 能cover [1, n]
     * 这里不能直接使用permutation, 而是需要考虑一个trick:
     * [0, n] -> [0, n+1) -> 当我们添加n+1进入到数组后, 我们就能延展抵达的范围到: [0, (n + 1) + n] -> [0, 2(n+1)]
     */
    public int minPatches(int[] nums, int n) {
        // reaching 就是当前数组能组成的最大的数, 用long避免溢出
        long reaching = 1;
        int added = 0, i = 0;
        // 由于是开区间 == 也还不算reach到
        while (reaching <= n) {
            if (i < nums.length && nums[i] <= reaching) {
                // 不超出length的范围下, 如果当前reaching是大于nums[i], 那么reaching加上nums最新的一个(因为nums是递增的)
                reaching += nums[i++];
            } else {
                // 如果超出length, 或者nums[i] > reaching, 直接加入意义不大, 应该直接加入reaching这个数字, 来抵达更远的区间
                reaching += reaching;
                // 指添加一个数字
                added++;
            }
        }
        return added;
    }
}
