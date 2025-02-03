package Ex3105_LongestStrictlyIncreasingOrStrictlyDecreasingSubarray;

public class Solution {

    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int incLen = 1, decLen = 1, maxLen = 1;
        for (int pos = 1; pos < nums.length; pos++) {
            if (nums[pos] > nums[pos - 1]) {
                incLen++;
                decLen = 1;
            } else if (nums[pos] < nums[pos - 1]) {
                incLen = 1;
                decLen++;
            } else {
                incLen = 1;
                decLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }
        return maxLen;
    }
}
