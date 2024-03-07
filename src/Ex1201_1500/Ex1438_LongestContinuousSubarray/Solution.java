package Ex1201_1500.Ex1438_LongestContinuousSubarray;

import java.util.*;

public class Solution {

    /**
     * 题目需要找到, subArray中最大值与最小值之差, 要<=limit, 找最长的subArray的长度
     * 下面是使用TreeSet, 查询和insert/delete都是O(logN)
     */
    public static int longestSubarray_TreeSet(int[] nums, int limit) {

        int left = 0;
        TreeSet<Integer> treeSet = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        treeSet.add(0);

        int res = 1;
        for (int right = 1; right < nums.length; right++) {
            treeSet.add(right);
            while (nums[treeSet.last()] - nums[treeSet.first()] > limit) {
                treeSet.remove(left++);
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 2, 4, 7};
        System.out.println(longestSubarray_TreeSet(nums, 4));
    }
}
