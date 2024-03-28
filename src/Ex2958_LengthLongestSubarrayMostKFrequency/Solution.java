package Ex2958_LengthLongestSubarrayMostKFrequency;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 题目需要找出最长子序列, 序列中所有元素不能超出k频次
     */
    public static int maxSubarrayLength(int[] nums, int k) {

        // 由于是最长连续子序列, 肯定是跟twoPointer相关,
        // 这里的pointer设置为end和start, end负责向右, start是左边指示
        int res = 0, start = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int end = 0; end < nums.length; end++) {
            // 先进行频率添加
            freq.put(nums[end], 1 + freq.getOrDefault(nums[end], 0));
            // 如果超过k, 需要移动start并更新其频次
            while (freq.get(nums[end]) > k) {
                freq.put(nums[start], freq.get(nums[start]) - 1);
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
    }
}
