package Ex639_DecodeWaysII;

public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '0'){
            return 0;
        }
        int m = 1000000007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;

        for(int i = 2; i < n + 1; i++){
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);
            if(second == '*'){
                dp[i] += 9 * dp[i - 1];
            } else if(second != '0'){
                dp[i] += dp[i - 1];
            }

            if(first == '*'){
                if(second == '*'){
                    dp[i] += 15 * dp[i - 2];
                } else if(second <= '6') {
                    dp[i] += 2 * dp[i - 2];
                } else {
                    dp[i] += dp[i - 2];
                }

            } else if(first == '1'){
                if(second == '*'){
                    dp[i] += 9 * dp[i - 2];
                } else{
                    dp[i] += dp[i - 2];
                }
            } else if(first == '2'){
                if(second == '*'){
                    dp[i] += 6 * dp[i - 2];
                } else if(second <= '6'){
                    dp[i] += dp[i - 2];
                }
            }


            dp[i] %= m;
        }
        return (int)dp[n];
    }
}
