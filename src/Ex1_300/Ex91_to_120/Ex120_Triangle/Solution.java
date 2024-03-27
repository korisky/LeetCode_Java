package Ex1_300.Ex91_to_120.Ex120_Triangle;

import java.util.List;

/**
 * This is a simple dynamic programming problem, real trick here is using bottom up solution
 * <p>
 * If we go downward to judge the minimum path, we have so many situation need to take care (0: mid, right -2: mid: left, mid ...)
 * But it would make our life much more easier to go bottom up
 */

public class Solution {

    /**
     * 考虑使用向下收缩, dp的核心公式就变成简单的 dp[j] = MIN(dp[j], dp[j + 1]) + 当前本身num
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // 这里+1是为了方便不要越界
        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 由于是反向收缩, 这里的j+1还可以确保不会越界
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
