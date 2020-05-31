package EX31_to_60.Ex48_RotateImage;

/*
        The idea is about: do horizontal flip, then do transpose, then would be rotate 90 degree to the right

        1, 2, 3,            7, 8, 9,            7, 4, 1
        4, 5, 6,    ->      4, 5, 6,    ->      8, 5, 2
        7, 8, 9,            1, 2, 3,            9, 6, 3
 */

public class Solution {
    public void rotate(int[][] matrix) {
        // 1. horizontal flip
        for (int rStart = 0, rEnd = matrix.length - 1; rStart < rEnd; rStart++, rEnd--)
            swap(matrix, rStart, rEnd, true);

        // 2. transform
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[0].length; col++) { // if we use col = 0 to start
                                                                // it would swap BACK
                swap(matrix, row, col, false);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, boolean isLine) {
        if (isLine) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        } else {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] line1 = new int[]{1, 2, 3};
        int[] line2 = new int[]{4, 5, 6};
        int[] line3 = new int[]{7, 8, 9};
        int[][] matrix = new int[3][3];
        matrix[0] = line1;
        matrix[1] = line2;
        matrix[2] = line3;

        Solution use = new Solution();
        use.rotate(matrix);
    }
}
