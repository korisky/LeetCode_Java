package Ex174_DungeonGame;

/*
    For the knight's path, e.g. -2, -3, 5. We can not make it as 0, because
    we can only 'use' the positive 5 to 'alleviate' next negative damage

    Thus, we can do 'regression', then we can eliminate the 'positive' herb problem.

    1. Thinking about we are at the bottom-right corner now, BEFORE going into this slot, what's
        the minimum health we need to save the princes?
        1.1 If current slot only have herb (positive), our health is >= 1 that means we are survived
            minHealth[rowLen - 1][col - 1] >= 1
        1.2 If current slot have demon (negative), our health need to greater than the demon's damage
            at least 1, : minHealth[rowLen - 1][col - 1] + dungeon[rowLen - 1][col - 1] >= 1

        Conclusion, we wanna save princess, we need at least:
            minHealth[rolLen - 1][colLen - 1] = Math.max(1, 1 - dungeon[rowLen - 1][col - 1])  ---- formula_1

    2. What about the formula before the last slot ? Now consider PREV is just ONE SLOT BEFORE the last one.
        2.1 If the rest slots are all herbs, we only need PREV health >= 1, then we can go to the last slot
            and use the formula_1. : minHealth[row - 2][col - 2] >= 1
        2.2 If still have demons between current slot and the last one, we need to consider the damage:
            minHealth[PREV] >= minHealth[CUR] - dungeon[PREV]

        Conclusion, we can general above into:
            minHealth[PREV] = Math.max(1, minHealth[CUR] - dungeon[PREV])

    3. Then what ? Cause we doing 'REGRESSION', we can only move left and upward, then how to choose direction ?
        !! Choose the one with minimal health !!
        minHealth[r][c] = Math.min(Math.max(1, minHealth[r + 1][c] - dungeon[r][c])........)

    4. We can make it into 1-d array to store !

    IMP: minHealth[r + 1][c] - dungeon[r][c] means: the health we go after this slot, and the dungeon damage of
        current slot

 */

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rowLen = dungeon.length;
        int colLen = dungeon[0].length;

        int[] minHealth = new int[colLen];
        minHealth[colLen - 1] = dungeon[rowLen - 1][colLen - 1];

        for (int row = rowLen - 1; row >= 0; row--) {
            for (int col = colLen - 1; col >= 0; col--) {
                if (row == rowLen - 1 && col == colLen - 1) { // at bottom-right
                    minHealth[col] = Math.max(1, 1 - dungeon[row][col]);
                } else if (col == colLen - 1) { // for the last col, can only be moved from downward
                    minHealth[col] = Math.max(1, minHealth[col] - dungeon[row][col]);
                } else if (row == rowLen - 1) { // for the last row, can only be moved from right
                    minHealth[col] = Math.max(1, minHealth[col + 1] - dungeon[row][col]);
                } else { // for the slots in the middle, we need to judge from two directions
                    minHealth[col] = Math.min(Math.max(1, minHealth[col] - dungeon[row][col]),
                            Math.max(1, minHealth[col + 1] - dungeon[row][col]));
                }
            }
        }
        return minHealth[0];
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] row1 = new int[]{-3, 2, 4, -10};
        int[] row2 = new int[]{-1, -10, 3, -2};
        int[] row3 = new int[]{1, 2, -1, -2};

        int[][] test = new int[3][4];
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        System.out.println(use.calculateMinimumHP(test));
    }
}
