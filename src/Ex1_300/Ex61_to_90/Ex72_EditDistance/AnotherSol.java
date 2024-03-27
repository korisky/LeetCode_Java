package Ex1_300.Ex61_to_90.Ex72_EditDistance;

public class AnotherSol {
    public int minDistance(String word1, String word2) {

        int w1Len = word1.length();
        int w2Len = word2.length();
        if (w1Len == 0) {
            return w2Len;
        } else if (w2Len == 0) {
            return w1Len;
        }

        // +1 为两者都是空字符串的情况
        int[][] dp = new int[w1Len + 1][w2Len + 1];
        dp[0][0] = 0;

        // 1) 初始化行与列, 因为当另一个字符串为空时, 两者dif就是当前这个位置(index就是使用了多少个字符)
        for (int i = 1; i <= w1Len; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= w2Len; i++) {
            dp[0][i] = i;
        }

        // 2) dp遍历, 核心是判断s1[i-1]与s2[j-1]是否相同,
        // 相同: dp[i][j] = dp[i-1][j-1]
        // 不同: dp[i][j] = 1 + min(dp[i-1][j-1]对角, dp[i-1][j]只取上面来的, dp[i][j-1]只取左边来的)
        for (int i = 1; i <= w1Len; i++) {
            for (int j = 1; j <= w2Len; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[w1Len][w2Len];
    }

    public static void main(String[] args) {
        AnotherSol use = new AnotherSol();
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(use.minDistance(s1, s2));
    }
}
