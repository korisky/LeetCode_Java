package Ex1201_1500.Ex1289_MinimumFallingPathSumII;

public class Solution {

    /**
     * Ex931的变化版, 不允许连续使用同一列的路径, 允许跳选 (不一定是adjacent的, 这个与Ex931不同)
     * 所以这里的核心是需要维护上一行获得的数据的2个最小值
     */
    public int minFallingPathSum(int[][] grid) {

        return 0;
    }

    /**
     * 官方的一纬DP解
     */
    public int minFallingPathSumOfficialBest(int[][] grid) {

        int n = grid.length;

        // Minimum and Second Minimum Column Index
        int nextMin1C = -1;
        int nextMin2C = -1;

        // Minimum and Second Minimum Value
        int nextMin1 = -1;
        int nextMin2 = -1;

        // Find the minimum and second minimum from the last row
        for (int col = 0; col < n; col++) {
            if (nextMin1 == -1 || grid[n - 1][col] <= nextMin1) {
                nextMin2 = nextMin1;
                nextMin2C = nextMin1C;
                nextMin1 = grid[n - 1][col];
                nextMin1C = col;
            } else if (nextMin2 == -1 || grid[n - 1][col] <= nextMin2) {
                nextMin2 = grid[n - 1][col];
                nextMin2C = col;
            }
        }

        // Fill the recursive cases
        for (int row = n - 2; row >= 0; row--) {
            // Minimum and Second Minimum Column Index of the current row
            int min1C = -1;
            int min2C = -1;

            // Minimum and Second Minimum Value of current row
            int min1 = -1;
            int min2 = -1;

            for (int col = 0; col < n; col++) {
                // Select minimum from valid cells of the next row
                int value;
                if (col != nextMin1C) {
                    value = grid[row][col] + nextMin1;
                } else {
                    value = grid[row][col] + nextMin2;
                }

                // Save minimum and second minimum
                if (min1 == -1 || value <= min1) {
                    min2 = min1;
                    min2C = min1C;
                    min1 = value;
                    min1C = col;
                } else if (min2 == -1 || value <= min2) {
                    min2 = value;
                    min2C = col;
                }
            }

            // Change of row. Update nextMin1C, nextMin2C, nextMin1, nextMin2
            nextMin1C = min1C;
            nextMin2C = min2C;
            nextMin1 = min1;
            nextMin2 = min2;
        }

        // Return the minimum from the first row
        return nextMin1;
    }


    /**
     * 官方的2纬DP方法
     */
    public int minFallingPathSumOfficial(int[][] grid) {
        // Initialize a two-dimensional array to cache the result of each sub-problem
        int[][] memo = new int[grid.length][grid.length];

        // Fill the base case
        for (int col = 0; col < grid.length; col++) {
            memo[grid.length - 1][col] = grid[grid.length - 1][col];
        }

        // Fill the recursive cases
        for (int row = grid.length - 2; row >= 0; row--) {
            for (int col = 0; col < grid.length; col++) {
                // Select minimum from valid cells of next row
                int nextMinimum = Integer.MAX_VALUE;
                for (int nextRowCol = 0; nextRowCol < grid.length; nextRowCol++) {
                    // 跳过用过的一列
                    if (nextRowCol != col) {
                        // 相当于寻找second minimum
                        nextMinimum = Math.min(nextMinimum, memo[row + 1][nextRowCol]);
                    }
                }

                // Minimum cost from this cell
                memo[row][col] = grid[row][col] + nextMinimum;
            }
        }

        // Find the minimum from the first row
        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < grid.length; col++) {
            answer = Math.min(answer, memo[0][col]);
        }

        // Return the answer
        return answer;
    }
}
