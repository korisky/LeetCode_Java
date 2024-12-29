package Ex1501_1800.Ex1639_NumWaysFormTargetStrGivenDic;

public class Solution {

    final static int MOD = 1000000007;

    /**
     * 使用自下而上的dp动态规划
     */
    public static int numWays(String[] words, String target) {

        int wordLen = words[0].length();
        int targetLen = target.length();

        // Step1: calculate frequency of each char at every idx (no matter in which word)
        int[][] charFrequency = new int[wordLen][26];
        for (String word : words) {
            for (int j = 0; j < wordLen; j++) {
                charFrequency[j][word.charAt(j) - 'a']++;
            }
        }

        // Step2: init dp table
        long[][] dp = new long[wordLen + 1][targetLen + 1];
        for (int curWord = 0; curWord <= wordLen; curWord++) {
            dp[curWord][0] = 1;
        }

        // Step3: fill dp table
        for (int curWord = 1; curWord <= wordLen; curWord++) {
            for (int curTarget = 1; curTarget <= targetLen; curTarget++) {
                // carry over the previous val
                dp[curWord][curTarget] = dp[curWord - 1][curTarget];

                // add ways using curIdx of 'words' if the char match
                int curPos = target.charAt(curTarget - 1) - 'a';
                dp[curWord][curTarget] += (charFrequency[curWord - 1][curPos] * dp[curWord - 1][curTarget - 1]) % MOD;
                dp[curWord][curTarget] %= MOD;
            }
        }

        // Step4: result is bottom right
        return (int) dp[wordLen][targetLen];
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"acca", "bbbb", "caca"};
        String target = "aba";
        System.out.println(numWays(strArr, target));
    }
}
