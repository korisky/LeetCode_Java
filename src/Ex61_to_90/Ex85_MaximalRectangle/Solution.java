package Ex61_to_90.Ex85_MaximalRectangle;

/*
    The idea is about: traversing each row, record the leftest and rightest continuous element'index
    then with the height, we can calculate the max area rectangle
 */

import java.util.Arrays;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0)
            return 0;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int maxArea = 0;
        int[] left = new int[colLen];
        int[] right = new int[colLen];
        int[] height = new int[colLen];
        Arrays.fill(right, colLen - 1);

        for (char[] chars : matrix) {
            int rBar = colLen - 1;
            for (int col = colLen - 1; col >= 0; col--) {
                if (chars[col] == '1') {
                    right[col] = Math.min(right[col], rBar);
                } else {
                    right[col] = colLen - 1;
                    rBar = col - 1;
                }
            }
            int lBar = 0;
            for (int col = 0; col < colLen; col++) {
                if (chars[col] == '1') {
                    height[col]++;
                    left[col] = Math.max(left[col], lBar);
                    maxArea = Math.max(maxArea, height[col] * (right[col] - left[col] + 1));
                } else {
                    height[col] = 0;
                    left[col] = 0;
                    lBar = col + 1;
                }
            }
        }
        return maxArea;
    }
}
