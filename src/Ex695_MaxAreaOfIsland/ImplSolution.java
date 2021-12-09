package Ex695_MaxAreaOfIsland;

public class ImplSolution {
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
                    maxArea = Math.max(maxArea, sink(theGrid, row, col));
                }
            }
        }
        return maxArea;
    }

    public int sink(int[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                && grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + sink(grid, row - 1, col) + sink(grid, row + 1, col)
                    + sink(grid, row, col - 1) + + sink(grid, row, col + 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        ImplSolution s = new ImplSolution();
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
