package Ex1_300.Ex61_to_90.Ex85_MaximalRectangle;

import java.util.Arrays;

public class AnotherSol {

    /**
     * 题目希望找到存在的最大长方体的面积，使用DP进行记录, 这里的方法是进行3次遍历保存DP的值
     * 1）从上到下
     * - 这个比较好理解, 从行1到行n, 从左到右进行height持续递增 (用1纬数组进行存储)
     * - 如果上一行这个位置从
     * 1）从左到右
     * 2）从右到左
     */
    public int maximalRectangle(char[][] matrix) {

        if (null == matrix || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[] left = new int[m];
        int[] right = new int[m];
        int[] height = new int[m];

        // 初始化right
        Arrays.fill(right, m);

        int area = 0;
        for (int i = 0; i < n; i++) {
            int curLeft = 0, curRight = m;

            // 计算高度, 这里存储的是直接的高度
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            // 计算从左到右, 这里存储的是左index, 所以要更靠右的(max)
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            // 计算从右到左, 这里存储的是右index, 所以要更靠左的(min)
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = m;
                    curRight = j;
                }
            }

            // 最后计算面积
            for (int j = 0; j < m; j++) {
                area = Math.max(area, (right[j] - left[j]) * height[j]);
            }
        }

        return area;
    }
}
