package Ex121_to_150.Ex132_PalindromePartitioning2;

import java.util.stream.IntStream;

public class Solution {
    public int minCut(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int N = s.length();
        // initial value with dp[i] = i
        int[] dp = IntStream.range(0, N).toArray();

        // iterate through all chars as mid point of palindrome
        for (int mid = 1; mid < N; mid++) {
            // CASE 1: odd len : center is at index mid, expand on both sides
            for (int start = mid, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
            // CASE 2: even len: center is between [mid - 1, mid], expand on both sides
            for (int start = mid - 1, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
        }

        return dp[N - 1];
    }
}
