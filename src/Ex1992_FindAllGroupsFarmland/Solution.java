package Ex1992_FindAllGroupsFarmland;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题的重点在于, 每个这种farmland都是矩形, 所以长和宽只需要expand即可
 */
public class Solution {
    public int[][] findFarmland(int[][] land) {
        if (null == land) {
            return null;
        }
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    // sink the land
                    sink(land, i, j, results);
                }
            }
        }
        return results.toArray(new int[results.size()][]);
    }

    private void sink(int[][] land, int row, int col, List<int[]> results) {
        int endRow = row;
        int endCol = col;
        int maxRow = land.length - 1;
        int maxCol = land[0].length - 1;
        // find rightest X coordinate
        while (endRow + 1 <= maxRow && land[endRow + 1][col] == 1) {
            land[endRow + 1][col] = 0;
            endRow++;
        }
        // find bottom Y coordinate
        while (endCol + 1 <= maxCol && land[row][endCol + 1] == 1) {
            land[row][endCol + 1] = 0;
            endCol++;
        }
        // sink all cube surround
        for (int i = row; i <= endRow; i++) {
            for (int j = col; j <= endCol; j++) {
                land[i][j] = 0;
            }
        }
        // add result
        results.add(new int[]{row, col, endRow, endCol});
    }
}
