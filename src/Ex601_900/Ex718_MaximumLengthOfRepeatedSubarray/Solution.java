package Ex601_900.Ex718_MaximumLengthOfRepeatedSubarray;

public class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length + 1;
        int n = B.length + 1;
        int[][] maxLenDp = new int[m][n];
        int maxLen = 0;
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (A[r - 1] == B[c - 1]) {
                    maxLenDp[r][c] = maxLenDp[r - 1][c - 1] + 1;
                    maxLen = Math.max(maxLen, maxLenDp[r][c]);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] A = new int[]{1, 0, 0, 0, 1};
        int[] B = new int[]{1, 0, 0, 1, 1};

        System.out.println(use.findLength(A, B));
    }
}
