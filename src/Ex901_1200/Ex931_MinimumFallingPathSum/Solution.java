package Ex901_1200.Ex931_MinimumFallingPathSum;

public class Solution {

    /**
     * 题目希望从上到下, 找到一条求和最小的路径, 选中当前slot之后, 下一行可以选择对角线, 或者是直接往下的
     * 很明显的DP问题, 核心在于构建方向, bottom-up的方式是更合理的, 另外需要记住, 使用1-d动态规划, 要考虑更新时会不会影响, 是否需要额外临时数组
     */
    public static int minFallingPathSum(int[][] matrix) {

        if (null == matrix) return 0;

        // dp保存最短的选择的sum (注意是记录上一行的)
        int dp[] = new int[matrix.length + 1];

        // 使用bottom-up, 寻找路径的同时, 把当前位置的值加上
        for (int r = matrix.length - 1; r >= 0; r--) {
            int[] tmp = new int[matrix[0].length];
            for (int c = 0; c < matrix[0].length; c++) {
                if (c == 0) {
                    // 最左
                    tmp[c] += Math.min(dp[c], dp[c + 1]) + matrix[r][c];
                } else if (c == matrix[0].length - 1) {
                    // 最右
                    tmp[c] += Math.min(dp[c], dp[c - 1]) + matrix[r][c];
                } else {
                    // 中间
                    tmp[c] += Math.min(dp[c], Math.min(dp[c - 1], dp[c + 1])) + matrix[r][c];
                }
            }
            // 复制回去
            dp = tmp;
        }

        // 找到最短路径
        int pathMin = Integer.MAX_VALUE;
        for (int c = 0; c < matrix[0].length; c++) {
            pathMin = Math.min(pathMin, dp[c]);
        }

        return pathMin;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int[][] matrix = new int[][]{{100, -42, -46, -41}, {31, 97, 10, -10}, {-58, -51, 82, 89}, {51, 81, 69, -51}};
        System.out.println(minFallingPathSum(matrix));
    }
}
