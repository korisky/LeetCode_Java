package Ex1_300.Ex61_to_90.Ex72_EditDistance;

/*
    Let following be the function definition :-

        f(i, j) := minimum cost (or steps) required to convert
        first i characters of word1 to first j characters of word2

        Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
                            f(i, j) = f(i - 1, j - 1)

        Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper

                            f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }

                            1. f(i, j - 1) represents insert operation
                            2. f(i - 1, j) represents delete operation
                            3. f(i - 1, j - 1) represents replace operation
 */

public class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] cost = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++)
            cost[i][0] = i;
        for (int i = 1; i < n; i++)
            cost[0][i] = i; // meas: for an empty string "", if we want to convert it into "a", "ab", "abc"
        // we need 'change' once, twice ......

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (word1.charAt(r) == word2.charAt(c))
                    cost[r + 1][c + 1] = cost[r][c]; // mean we do not need to do anything
                else {
                    int replace = cost[r][c];
                    int insert = cost[r + 1][c];
                    int delete = cost[r][c + 1];
                    cost[r + 1][c + 1] = Math.min(replace, Math.min(insert, delete)) + 1;
                }
            }
        }
        return cost[m][n];
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(use.minDistance(s1, s2));
    }
}
