package Ex1_300.Ex61_to_90.Ex73_SetMatrixZeros;

/*
    Idea from LeetCode:
        If we find matrix[r][c] == 0, then we set: matrix[r][0] and matrix[0][c] as 0,
        then after row + col traversing, we can traverse again and let the [0] row and [0]
        to set all 0;

        BUT, in a situation, what if the first row or col already contain a 0?
        we just simply add two boolean stuff, to represent: first row and col
        contains 0 or not would be all fine.

        then the space would be O(1)
 */

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firRow0 = false;
        boolean firCol0 = false;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (matrix[r][c] == 0) {
                    if (r == 0)
                        firRow0 = true;
                    if (c == 0)
                        firCol0 = true;
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        for (int r = 1; r < rowLen; r++) {
            for (int c = 1; c < colLen; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0)
                    matrix[r][c] = 0;
            }
        }
        if (firRow0) {
            for(int c = 0; c < colLen; c++)
                matrix[0][c] = 0;
        }
        if (firCol0) {
            for (int r = 0; r < rowLen; r++)
                matrix[r][0] = 0;
        }
    }
}
