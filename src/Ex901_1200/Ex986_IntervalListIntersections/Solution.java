package Ex901_1200.Ex986_IntervalListIntersections;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int pA = 0;
        int pB = 0;
        while (pA < A.length && pB < B.length) {
            int interL = Math.max(A[pA][0], B[pB][0]);
            int interR = Math.min(A[pA][1], B[pB][1]);
            if (interL <= interR)
                list.add(new int[]{interL, interR});
            if (A[pA][1] < B[pB][1]) // we must compare the right boundary rather than the left one
                pA++;
            else
                pB++;
        }
        return list.toArray(new int[list.size()][]);
    }


    public static void main(String[] args) {
        Solution use = new Solution();
        int[][] test1 = new int[][]{{3, 5}, {9, 20}};
        int[][] test2 = new int[][]{{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}};
        int[][] res = use.intervalIntersection(test1, test2);
        for (int[] row : res) {
            for (int num : row)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
