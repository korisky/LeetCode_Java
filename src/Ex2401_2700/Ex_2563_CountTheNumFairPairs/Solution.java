package Ex2401_2700.Ex_2563_CountTheNumFairPairs;

import java.util.Arrays;

public class Solution {

    /**
     * 题目的fair定义容易导致歧义, 实际上[a,b], [b,a]仍然保留i>j, 所以排序并不会影响
     * 另外这里使用的是pair的数量与当前pointer所在位置是相同的(Lee's 叠加idx法)
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lowerBound(nums, upper + 1) - lowerBound(nums, lower);
    }

    private long lowerBound(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < val) {
                // 在val之内, 添加pair数量
                result += (right - left);
                left++;
            } else {
                // 超出val, 证明过大, 降低rightIdx
                right--;
            }
        }
        return result;
    }
}
