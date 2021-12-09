package Ex1905_CountSubIslands;

/**
 * 问题是需要找到grid2中的island, 并且其坐标是在grid1中的island的坐标之内,
 * 实质上应该是在sink其中grid2的island时, 每一个land都应该在grid1中属于land(不需要管是不是同一个island),
 * 所以, 一个可能的实现方式是, sink在grid2中的island时, 如果出现了该slot是land, 我们也需要确认grid1中该位置是land, 否则认为不是
 */
public class Solution {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if (null == grid1 || null == grid2) {
            return 0;
        }
        int nums = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1) {
                    nums += sink(grid2, grid1, i, j);
                }
            }
        }
        return nums;
    }

    private int sink(int[][] grid2, int[][] grid1, int row, int col) {
        // bottom case, or it's water
        if (row < 0 || row > grid2.length - 1 || col < 0 || col > grid2[0].length - 1
                || grid2[row][col] == 0) {
            // in here, we should return 1, which represent it's 'a' sub-island
            return 1;
        }
        // is land, go all direction first, then go check grid1[][] is also land or not
        grid2[row][col] = 0;
        int compare = 1;
        compare &= sink(grid2, grid1, row - 1, col);
        compare &= sink(grid2, grid1, row + 1, col);
        compare &= sink(grid2, grid1, row, col - 1);
        compare &= sink(grid2, grid1, row, col + 1);
        // all direction is sub-island, we still need to check grid1's corresponding slot is land or not
        return compare & grid1[row][col];
    }


    public static void main(String[] args) {

        int a = 1;
        int b = 0;
        System.out.println(a & a);
        System.out.println(a & b);
        System.out.println(b & a);
        System.out.println(b & b);
    }
}
