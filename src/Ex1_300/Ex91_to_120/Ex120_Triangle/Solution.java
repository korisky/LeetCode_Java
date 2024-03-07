package Ex1_300.Ex91_to_120.Ex120_Triangle;

import java.util.List;

/**
 * This is a simple dynamic programming problem, real trick here is using bottom up solution
 *
 * If we go downward to judge the minimum path, we have so many situation need to take care (0: mid, right -2: mid: left, mid ...)
 * But it would make our life much more easier to go bottom up
 */

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle.size() == 0)
//            return 0;
//
//        for (int i = triangle.size() - 2; i >= 0; i--) {
//            List<Integer> nextLevel = triangle.get(i + 1);
//            int firstVal = Math.min(nextLevel.get(0), nextLevel.get(1)) + triangle.get(i).get(0);
//            triangle.get(i).set(0, firstVal);
//            for (int j = 1; j <= i; j++) {
//                int curSum = Math.min(nextLevel.get(j + 1), Math.min(nextLevel.get(j), nextLevel.get(j + 1)))
//                        + triangle.get(i).get(j);
//                triangle.get(i).set(j, curSum);
//            }
//        }
//        return triangle.get(0).get(0);

        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
