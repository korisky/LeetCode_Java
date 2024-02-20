package Ex181_to_210.Ex209_MinimumSizeSubarraySum;

/*
    Example:
    Input: s = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int curSum = 0;
        int minLen = Integer.MAX_VALUE;

        while (end < nums.length) {
            if (nums[end] >= s)
                return 1; // one digit is already greater than s
            curSum += nums[end++];
            while (curSum >= s) {
                minLen = Math.min(minLen, end - start);
                curSum -= nums[start++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.minSubArrayLen(7, new int[]{1, 3, 1, 2, 2, 5}));
    }
}
