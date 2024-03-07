package Ex601_900.Ex764_LargestPlusSign;

import java.util.Arrays;

/*
    The similar problem like Q84 finding square and Q85 finding rectangle and this question finding
    big PLUS sign, for handling these kind of question, we have a pattern here:

        use a new matrix to store, keep going from left, right
        then going from upper to downward. If we meet '1', keep adding the current count,
        if we meet '0', go and reset the count = 0.

        Then lastly, we can go and get all different sign by this
 */

public class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] countMatrix = new int[N][N];
        int maxPlusLen = 0;
        // 1. setting up the matrix
        for (int[] arr : countMatrix) {
            Arrays.fill(arr, 1);
        }
        for (int[] arr : mines) {
            countMatrix[arr[0]][arr[1]] = 0;
        }
        // 2. from up 2 bottom, go left 2 right & right 2 left
        for (int row = 0; row < N; row++) {
            int lCount = 0; // left 2 right
            for (int col = 0; col < N; col++) {
                if (countMatrix[row][col] != 0)
                    lCount++;
                else
                    lCount = 0;
                countMatrix[row][col] = lCount;
            }
            int rCount = 0; // right 2 left
            for (int col = N - 1; col >= 0; col--) {
                if (countMatrix[row][col] != 0)
                    rCount++;
                else
                    rCount = 0;
                countMatrix[row][col] = Math.min(countMatrix[row][col], rCount);
            }
        }
        // 3. from left 2 right, go up 2 bottom & bottom up
        for (int col = 0; col < N; col++) {
            int uCount = 0; // up 2 down
            for (int row = 0; row < N; row++) {
                if (countMatrix[row][col] != 0)
                    uCount++;
                else
                    uCount = 0;
                countMatrix[row][col] = Math.min(countMatrix[row][col], uCount);
            }
            int dCount = 0; // bottom up
            for (int row = N - 1; row >= 0; row--) {
                if (countMatrix[row][col] != 0)
                    dCount++;
                else
                    dCount = 0;
                countMatrix[row][col] = Math.min(countMatrix[row][col], dCount);
                maxPlusLen = Math.max(maxPlusLen, countMatrix[row][col]);
            }
        }
        return maxPlusLen;
    }
}
