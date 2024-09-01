package Ex1801_2100.Ex2022_Convert1DArrayInto2DArray;

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

    public static void main(String[] args) {
        System.out.println(construct2DArray(new int[]{1, 2, 3, 4}, 2, 2));
    }
}
