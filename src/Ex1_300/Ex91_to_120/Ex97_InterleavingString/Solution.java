package Ex1_300.Ex91_to_120.Ex97_InterleavingString;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        // dp[i][j] = true here means: s1 [0...i-1] and s2 [0...j-1] interleaved with s3 [0 ... i + j - 1]

        // if s2 is empty
        for (int i = 1; i <= len1; i++)
            dp[i][0] = (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1));

        // if s1 is empty
        for (int i = 1; i <= len2; i++)
            dp[0][i] = (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1));

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                dp[i][j] = (c1 == c3 && dp[i - 1][j]) || (c2 == c3 && dp[i][j - 1]);
                // here means: current should be true: whether s1 current char is equal to s3, and the chars before current
                // char in s1 should also in s3
            }
        }
        return dp[len1][len2];
    }
}
