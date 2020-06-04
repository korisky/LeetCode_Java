package EX31_to_60.Ex54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {

            // 1. go right
            for (int col = colStart; col <= colEnd; col++)
                res.add(matrix[rowStart][col]);
            rowStart++;

            // 2. go downward
            for (int row = rowStart; row <= rowEnd; row++)
                res.add(matrix[row][colEnd]);
            colEnd--;

            // 3. go left
            if (rowStart <= rowEnd) {
                // we need to check whether do we still need to add stuff,
                // this would happen (violate this if-statement) if input
                // matrix is not square
                for (int col = colEnd; col >= colStart; col--)
                    res.add(matrix[rowEnd][col]);
            }
            rowEnd--;

            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--)
                    res.add(matrix[row][colStart]);
            }
            colStart++;
        }
        return res;
    }
}
