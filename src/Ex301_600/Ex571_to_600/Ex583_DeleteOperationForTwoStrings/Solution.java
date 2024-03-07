package Ex301_600.Ex571_to_600.Ex583_DeleteOperationForTwoStrings;

/*
    This question is the Longest Common Subsequence:
        e.g. "abcdaf" & "acbcf", there LCS is "abcf" (not continues one would be all find)
 */

public class Solution {
    public int minDistance(String word1, String word2) {
        int w1Len = word1.length();
        int w2Len = word2.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        // can use 1-d array
        int[] lcs = new int[w2Len + 1];
        for (int r = 1; r <= w1Len; r++) {
            int diag = 0;
            for (int c = 1; c <= w2Len; c++) {
                int temp = lcs[c];
                if (w1[r - 1] == w2[c - 1])
                    lcs[c] = diag + 1;
                else
                    lcs[c] = Math.max(lcs[c], lcs[c - 1]);
                diag = temp;
            }
        }
        int lcsLen = lcs[w2Len];
        return w1Len + w2Len - 2 * lcsLen;

//        int[][] lcs = new int[w1Len + 1][w2Len + 1];
//        for (int r = 0; r <= w1Len; r++) {
//            for (int c = 0; c <= w2Len; c++) {
//                if (r == 0 || c == 0) {
//                    lcs[r][c] = 0;
//                } else if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
//                    lcs[r][c] = lcs[r - 1][c - 1] + 1;
//                } else {
//                    lcs[r][c] = Math.max(lcs[r - 1][c], lcs[r][c - 1]);
//                }
//            }
//        }
//        int lcsLen = lcs[w1Len][w2Len];
//        return w1Len + w2Len - 2 * lcsLen;
    }

    // If we want to go back and store the String:
    // from bottom-right: if dp[i-1][j-1] == dp[i][j], sb.append(word1.charAt(i - 1)), i--, j--
    // else: i - 1 || j - 1, choose the maximum one


    public static void main(String[] args) {
        Solution use = new Solution();
        String word1 = "horse";
        String word2 = "rose";
        System.out.println(use.minDistance(word1, word2));
    }
}
