package Ex1_300.Ex270_to_300.Ex300_LongestIncreasingSubsequence;

/**
 * 使用动态规划方法, 从拆分问题的方法开始看, 每一个全长的数组的最长连续递增数组, 都由它 -1 的最长连续数组的来,
 * 那么, 问题可以一直从右往左拆分, 一个指针单向从左向右遍历, 另一个指针一直从0开始向右到指针位置遍历,
 * 左指针每次都判断是否比右指针的值要小, < 既符合升序, dp中进行记录, 查看是当前i位置的dp历史长度大, 还是走左指针这个选择, 并在其基础上+1的更大
 * 将其进行记录, 如此遍历
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int max = 0;
        int[] maxLenLIS = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // at least 1
            maxLenLIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLenLIS[i] = Math.max(maxLenLIS[i], maxLenLIS[j] + 1);
                }
            }
            max = Math.max(max, maxLenLIS[i]);
        }

        return max;
    }
}
