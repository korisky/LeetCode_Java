package Ex91_to_120.Ex96_UniqueBinarySearchTrees;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int first = 0; first < i; first++) {
                dp[i] += dp[first] * dp[i - 1 - first];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.numTrees(2));
    }
}
