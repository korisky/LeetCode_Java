package Ex115_DistinctSubsequences;

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++)
            dp[0][i] = 1;

        for (int r = 1; r <= t.length(); r++) {
            for (int c = 1; c <= s.length(); c++) {
                if (s.charAt(c - 1) == t.charAt(r - 1))
                    dp[r][c] = dp[r - 1][c - 1] + dp[r][c - 1];
                else
                    dp[r][c] = dp[r][c - 1];
            }
        }
        return dp[t.length()][s.length()];
    }


    public static void main(String[] args) {
        Solution use = new Solution();
        String s = "babgbag";
        String t = "bag";
        System.out.println(use.numDistinct(s, t));
    }
}
