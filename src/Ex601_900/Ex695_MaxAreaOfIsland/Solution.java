package Ex601_900.Ex695_MaxAreaOfIsland;

/**
 * 与Ex200的计算孤岛数目类似, 需要使用sink的思想, 但这次需要记录每个岛的面积
 */
public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        // bottom case
        if (grid == null) {
            return 0;
        }
        // loop to check all island
        int[][] theGrid = grid.clone();
        int maxArea = 0;
        for (int row = 0; row < theGrid.length; row++) {
            for (int col = 0; col < theGrid[0].length; col++) {
                if (theGrid[row][col] != 0) {
                    int area = sink(theGrid, row, col, 0);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int sink(int[][] grid, int row, int col, int area) {
        // bottom case
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
            return area;
        }
        // if can be expand or sink
        if (grid[row][col] != 0) {
            grid[row][col] = 0;
            area++;
            // go traverse 4 directions
            area = Math.max(area, sink(grid, row - 1, col, area));
            area = Math.max(area, sink(grid, row + 1, col, area));
            area = Math.max(area, sink(grid, row, col - 1, area));
            area = Math.max(area, sink(grid, row, col + 1, area));
        }
        return area;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] test = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int i = s.maxAreaOfIsland(test);
        System.out.println(i);
    }
}
