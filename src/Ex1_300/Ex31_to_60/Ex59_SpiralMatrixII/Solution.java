package Ex1_300.Ex31_to_60.Ex59_SpiralMatrixII;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0)
            return matrix;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int curNum = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {

            // 1. go right
            for (int col = colStart; col <= colEnd; col++)
                matrix[rowStart][col] = curNum++;
            rowStart++;

            // 2. go downward
            for (int row = rowStart; row <= rowEnd; row++)
                matrix[row][colEnd] = curNum++;
            colEnd--;

            // 3. go left
            if (rowStart <= rowEnd) {
                // we need to check whether do we still need to add stuff,
                // this would happen (violate this if-statement) if input
                // matrix is not square
                for (int col = colEnd; col >= colStart; col--)
                    matrix[rowEnd][col] = curNum++;
            }
            rowEnd--;

            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--)
                    matrix[row][colStart] = curNum++;
            }
            colStart++;
        }
        return matrix;
    }
}
