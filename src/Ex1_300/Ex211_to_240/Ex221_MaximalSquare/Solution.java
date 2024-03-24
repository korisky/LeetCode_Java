package Ex1_300.Ex211_to_240.Ex221_MaximalSquare;

/*
    The idea is about: using the dynamic programming:
        Use a 2-d array to store the largest square's edge's length,
        It would be : min(left, upper, top-left diagonal) + 1
 */

public class Solution {
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int maxEdgeLength = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] edges = new int[rowLen + 1][colLen + 1];
        for (int r = 1; r <= rowLen; r++) {
            for (int c = 1; c <= colLen; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    // 这里的核心就是, 类似2d数组中的matrix为正方形的考虑, 要看[r-1][c], [r][c-1], 以及斜角[r][c]
                    edges[r][c] = 1 + Math.min(Math.min(edges[r - 1][c], edges[r][c - 1]), edges[r - 1][c - 1]);
                    maxEdgeLength = Math.max(maxEdgeLength, edges[r][c]);
                }
            }
        }
        return maxEdgeLength * maxEdgeLength;
    }

    public static void main(String[] args) {
        char[] row1 = new char[]{'1', '0', '1', '0', '0'};
        char[] row2 = new char[]{'1', '0', '1', '1', '1'};
        char[] row3 = new char[]{'1', '1', '1', '1', '1'};
        char[] row4 = new char[]{'1', '0', '0', '1', '0'};
        char[][] matrix = new char[][]{row1, row2, row3, row4};
        System.out.println(maximalSquare(matrix));
    }
}
