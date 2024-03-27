package Ex1_300.Ex91_to_120.Ex97_InterleavingString;

public class AnotherSol {

    /**
     * 非常经典的题目, 与之前算法课堂的伪代码实现类似
     */
    public static boolean isInterleave(String s1, String s2, String s3) {

        // 长度不同直接排除
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // 准备dp进行遍历, 我们需要从空字符串开始, 所以dp要多一行多一列
        // 行为取的s1的字符, 列为取的s2的字符
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // 初始化空字符串为可达
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                // 如果是第一行但不是第一列, 只取s2的意思, 所以只需要确认s2与s3当前位置合理性
                if (i == 0 && j > 0) {
                    dp[i][j] = (s2.charAt(j - 1) == s3.charAt(i + j - 1)) && dp[i][j - 1];
                    continue;
                }
                // 如果是第一列但不是第一行, 只取s1的意思, 所以只确认s1和s3当前位置合理性
                if (i > 0 && j == 0) {
                    dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1)) && dp[i - 1][j];
                    continue;
                }
                // 既不是第一行也不是第一列的情况, 需要考虑取s1可用性或者取s2可行
                dp[i][j] = ((s2.charAt(j - 1) == s3.charAt(i + j - 1)) && dp[i][j - 1])
                        || ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) && dp[i - 1][j]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * 可以发现, 由于计算的时候涉及的r那一纬, 实际上更新是不会被覆盖的, 所以可以使用更少空间的1D-DpArray
     */
    public static boolean isInterleave_1D(String s1, String s2, String s3) {

        // 长度不同直接排除
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // 准备dp进行遍历, 我们需要从空字符串开始, 所以dp要多一行多一列
        // 行为取的s1的字符, 列为取的s2的字符
        boolean[] dp = new boolean[s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // 初始化空字符串为可达
                if (i == 0 && j == 0) {
                    dp[j] = true;
                    continue;
                }
                // 如果是第一行但不是第一列, 只取s2的意思, 所以只需要确认s2与s3当前位置合理性
                if (i == 0 && j > 0) {
                    dp[j] = (s2.charAt(j - 1) == s3.charAt(j - 1)) && dp[j - 1];
                    continue;
                }
                // 如果是第一列但不是第一行, 只取s1的意思, 所以只确认s1和s3当前位置合理性
                if (i > 0 && j == 0) {
                    dp[j] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[j];
                    continue;
                }
                // 既不是第一行也不是第一列的情况, 需要考虑取s1可用性或者取s2可行
                dp[j] = ((s2.charAt(j - 1) == s3.charAt(i + j - 1)) && dp[j - 1])
                        || ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) && dp[j]);
            }
        }
        return dp[s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave_1D("aabcc", "dbbca", "aadbbcbcac"));
    }
}
