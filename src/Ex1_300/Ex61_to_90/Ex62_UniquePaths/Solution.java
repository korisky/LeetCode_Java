package Ex1_300.Ex61_to_90.Ex62_UniquePaths;

import java.util.HashSet;

/*
    If we use BFS, it would cause Time Limited Error
 */

public class Solution {

    private int result;

    public int uniquePaths(int m, int n) {
        result = 0;
        dfsPath(m, n, 0, 0, new HashSet<>(), m - 1, n - 1);
        return result;
    }

    public void dfsPath(int m, int n, int curRow, int curCol,
                        HashSet<int[]> visited, int moveDownLeft, int moveRightLeft) {
        if (!visited.contains(new int[]{curRow, curCol})) {
            // the path is valid only when we never visit it before
            if (curRow == m - 1 && curCol == n - 1) {
                // if we reach the bottom-right slot, we that would be one valid path
                result++;
            } else {
                // prevent we go to the same slot recurrently
                visited.add(new int[]{curRow, curCol});
                if (moveRightLeft > 0) { // go right
                    dfsPath(m, n, curRow, curCol + 1,
                            visited, moveDownLeft, moveRightLeft - 1);
                }
                if (moveDownLeft > 0) { // go downward
                    dfsPath(m, n, curRow + 1, curCol,
                            visited, moveDownLeft - 1, moveRightLeft);
                }
                visited.remove(new int[]{curRow, curCol});
            }
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.uniquePaths(3, 2));
    }
}
