package Ex2101_2400.Ex2370_LongestIdealSubsequence;

public class Solution {

    /**
     * 题目要求找到最长子序列(可以剔除某些字母, 但是顺序不能变), 该序列前后字母之间的排序不能超出k个字母
     */
    public int longestIdealString(String s, int k) {
        int res = 0, n = s.length(), dp[] = new int[150];
        for (int ci = 0; ci < n; ci++) {
            int i = s.charAt(ci);
            for (int j = i - k; j <= i + k; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            res = Math.max(res, ++dp[i]);
        }
        return res;
    }
}
