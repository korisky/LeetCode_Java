package Ex885_SpiralMatrixIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {

        int[][] matrix = new int[R * C][2];
        int rowStart = r0;
        int rowEnd = r0 + 1;
        int colStart = c0;
        int colEnd = c0 + 1;

        int met = 0;
        matrix[met][0] = r0;
        matrix[met][1] = c0;
        met++;
        colEnd--;
        rowEnd--;

        while (met < matrix.length) {
            // 1. go right
            colEnd++;
            for (int colMoveRight = colStart + 1; colMoveRight <= colEnd; colMoveRight++) {
                if (0 <= colMoveRight && colMoveRight < C
                        && 0 <= rowStart && rowStart < R) {
                    matrix[met][0] = rowStart;
                    matrix[met][1] = colMoveRight;
                    System.out.println(String.valueOf(rowStart) + '_' + String.valueOf(colMoveRight));
                    met++;
                }
                if (met == matrix.length)
                    return matrix;
            }
            System.out.println();


            // 2. go downward
            rowEnd++;
            for (int rowMoveDown = rowStart + 1; rowMoveDown <= rowEnd; rowMoveDown++) {
                if (0 <= colEnd && colEnd < C
                        && 0 <= rowMoveDown && rowMoveDown < R) {
                    matrix[met][0] = rowMoveDown;
                    matrix[met][1] = colEnd;
                    System.out.println(String.valueOf(rowMoveDown) + '_' + String.valueOf(colEnd));
                    met++;
                }
                if (met == matrix.length)
                    return matrix;
            }
            System.out.println();


            // 3. go left
            colStart--;
            for (int colMoveLeft = colEnd - 1; colMoveLeft >= colStart; colMoveLeft--) {
                if (0 <= colMoveLeft && colMoveLeft < C
                        && 0 <= rowEnd && rowEnd < R) {
                    matrix[met][0] = rowEnd;
                    matrix[met][1] = colMoveLeft;
                    System.out.println(String.valueOf(rowEnd) + '_' + String.valueOf(colMoveLeft));
                    met++;
                }
                if (met == matrix.length)
                    return matrix;
            }
            System.out.println();


            rowStart--;
            // 4. go upward
            for (int rowMoveUp = rowEnd - 1; rowMoveUp >= rowStart; rowMoveUp--) {
                if (0 <= colStart && colStart < C
                        && 0 <= rowMoveUp && rowMoveUp < R) {
                    matrix[met][0] = rowMoveUp;
                    matrix[met][1] = colStart;
                    System.out.println(String.valueOf(rowMoveUp) + '_' + String.valueOf(colStart));
                    met++;
                }
                if (met == matrix.length)
                    return matrix;
            }
            System.out.println();
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.spiralMatrixIII(5, 6, 1, 4));
    }
}
