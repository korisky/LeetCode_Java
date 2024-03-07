package Ex1_300.Ex91_to_120.Ex118_PascalsTriangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return new ArrayList<>();

        int[][] matrix = new int[numRows][numRows];
        List<List<Integer>> res = new LinkedList<>();

        for (int r = 0; r < numRows; r++) {
            matrix[r][0] = 1;
            List<Integer> curRow = new LinkedList<>();
            curRow.add(matrix[r][0]);
            for (int c = 1; c <= r; c++) {
                matrix[r][c] = matrix[r - 1][c - 1] + matrix[r - 1][c];
                curRow.add(matrix[r][c]);
            }
            res.add(curRow);
        }
        return res;
    }
}
