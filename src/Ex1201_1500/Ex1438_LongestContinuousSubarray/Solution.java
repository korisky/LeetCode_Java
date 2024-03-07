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

    /**
     * 这个是更快的方法, 理解较为困难, 暂时记录
     */
    public static int longestSubarray(int[] nums, int limit) {

        LinkedList<Integer> maxQ = new LinkedList<>();
        LinkedList<Integer> minQ = new LinkedList<>();

        int i = 0, j = 0;
        for (j = 0; j < nums.length; j++) {

            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[j]) {
                maxQ.removeLast();
            }
            maxQ.addLast(nums[j]);

            while (!minQ.isEmpty() && minQ.peekLast() > nums[j]) {
                minQ.removeLast();
            }

            minQ.addLast(nums[j]);
            if (maxQ.getFirst() - minQ.getFirst() > limit) {
                if (maxQ.peek() == nums[i]) {
                    maxQ.removeFirst();
                }
                if (minQ.peek() == nums[i]) {
                    minQ.removeFirst();
                }
                i++;
            }
        }
        return j - i;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{8, 2, 4, 7};
        System.out.println(longestSubarray(nums, 4));
    }
}
