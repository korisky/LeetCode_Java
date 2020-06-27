package Ex91_DecodeWays;

/*
    The idea ia using the dynamic programing method
 */

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int len = s.length();
        int[] dp = new int[len];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int idx = 1; idx < len; idx++) {
            int oneDigit = s.charAt(idx) - '0';
            int twoDigit = 10 * (s.charAt(idx - 1) - '0') + oneDigit;
            if (oneDigit != 0)
                dp[idx] += dp[idx - 1]; // update slot [idx]
            if (10 <= twoDigit && twoDigit <= 26)
                dp[idx] += (idx > 2 ? dp[idx - 2] : 1); // also update the same slot [idx]
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.numDecodings("123"));
    }
}
