package Ex1_300.Ex1_to_30.Ex5_LongestPalindromicSubstring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnotherSol {
    public String longestPalindrome(String s) {

        // conner case
        if (s == null) return null;

        // init dp, 行和列都是自己, 自己与自己比
        int n = s.length();
        int[][] dp = new int[s.length()][s.length()];
        char[] charArr = s.toCharArray();
        int startIdx = 0;
        int maxLen = 0;

        // 1) 单个字符就是回文, 设置1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            startIdx = i;
            maxLen = 1;
        }

        // 2) 双字符的情况下, 也是回文, e.g. bb, 设置2
        for (int i = 0; i < n - 1; i++) {
            if (charArr[i] == charArr[i + 1]) {
                dp[i][i + 1] = 1;
                maxLen = 2;
                startIdx = i;
            }
        }

        // 3) 初始化完毕, 我们要试图拓展maxLen
        int curLen = 3;
        while (curLen <= s.length()) {
            // i 不能超过 n - curLen
            for (int i = 0; i <= n - curLen; i++) {
                // j 就是另一个方向的i, 中间相隔的就是curLen
                int j = i + curLen - 1;
                // 两端相同, 并且上一个位置是1
                if (charArr[i] == charArr[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    if (maxLen < curLen) {
                        maxLen = curLen;
                        startIdx = i;
                    }
                }
            }
            curLen++;
        }
        return s.substring(startIdx, startIdx + maxLen);
    }

    public static void main(String[] args) {
        AnotherSol use = new AnotherSol();
        System.out.println(use.longestPalindrome("babad"));
    }
}
