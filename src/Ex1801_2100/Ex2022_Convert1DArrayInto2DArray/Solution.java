package Ex1801_2100.Ex2022_Convert1DArrayInto2DArray;

import java.util.Arrays;

public class Solution {

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] res = new int[m][n];
        int r = -1;
        for (int i = 0; i < original.length; i++) {
            // next row
            if (i % n == 0) {
                r++;
            }
            // copy
            res[r][i % n] = original[i];
        }
        return res;
    }

    public static int[][] construct2DArray_Faster(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] res = new int[m][n];
        for (int r = 0; r < m; r++) {
            res[r] = Arrays.copyOfRange(original, r * n, r * n + n);
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] slow = construct2DArray(new int[]{1, 2, 3, 4}, 2, 2);
        int[][] fast = construct2DArray_Faster(new int[]{1, 2, 3, 4}, 2, 2);
        System.out.println();
    }
}
