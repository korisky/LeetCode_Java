package Ex2401_2700.Ex2466_CountWaysToBuildGoodStrings;

public class Solution {

    final static int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int end = 1; end <= high; end++) {
            if (end >= zero) {
                dp[end] += dp[end - zero];
            }
            if (end >= one) {
                dp[end] += dp[end - one];
            }
            dp[end] %= MOD;
        }

        int answer = 0;
        for (int i = low; i <= high; i++) {
            answer += dp[i];
            answer %= MOD;
        }
        return answer;
    }
}
