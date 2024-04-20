package Ex1801_2100.Ex1992_FindAllGroupsFarmland;

import java.util.ArrayList;
import java.util.List;


public class AnotherSol {

    /**
     * 更加直接的greedy贪心算法
     */
    public int[][] findFarmlandConcise(int[][] land) {

        int n = land.length, m = land[0].length;
        List<int[]> ans = new ArrayList<>();

        for (int row1 = 0; row1 < n; row1++) {
            for (int col1 = 0; col1 < m; col1++) {
                // 当发现有1时, 进行贪心运算
                if (land[row1][col1] == 1) {
                    // 拓展的同时置0
                    int row2 = row1, col2 = col1;
                    for (; row2 < n && land[row2][col1] == 1; row2++) {
                        for (; col2 < m && land[row2][col2] == 1; col2++) {
                            land[row2][col2] = 0;
                        }
                    }
                    // 记录左上角和右下角
                    ans.add(new int[]{row1, col1, row2, col2});
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }


    /**
     * sink island的变形, 核心在于遇到1的位置时, 尝试向下和向右拓展(因为是从左到右从上到下进行遍历)
     */
    public int[][] findFarmland(int[][] land) {
        if (null == land) {
            return null;
        }
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) sink(land, i, j, results);
            }
        }
        return results.toArray(new int[results.size()][]);
    }

    /**
     * 1) 对连续1的位置进行拓展, 向下向右, 找到边界. (由于题目限制了这些matrix一定是矩阵形势出现, 如果不是的情况下则需要每次增长考虑右下角)
     * 2) 找到边界后, 这个边界之内的所有slot, 都需要全部sink掉
     */
    private void sink(int[][] land, int row, int col, List<int[]> result) {

        int endRow = row;
        int endCol = col;

        // 向下
        while (endRow + 1 < land.length && land[endRow + 1][col] == 1) {
            land[endRow + 1][col] = 0;
            endRow++;
        }

        // 向右
        while (endCol + 1 < land[0].length && land[row][endCol + 1] == 1) {
            land[row][endCol + 1] = 0;
            endCol++;
        }

        // sink -> 包含的部分全部置1
        for (int i = row; i <= endRow; i++) {
            for (int j = col; j <= endCol; j++) {
                land[i][j] = 0;
            }
        }

        // 记录左上角和右下角的位置
        result.add(new int[]{row, col, endRow, endCol});
    }
}
