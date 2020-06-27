package Ex61_to_90.Ex75_SortColors;

/*
    We only have three colors here: 0, 1, 2
    Thus, we use two pointer, point to the idx that next 0 should be and next 2 should be
    then we just keep swap them would be all right.

    really similar to the QuickSort
 */

public class Solution {
    public void sortColors(int[] nums) {
        int redPointer = 0;
        int bluePointer = nums.length - 1;
        int curIdx = 0;
        while (curIdx <= bluePointer) {
            if (nums[curIdx] == 0) {
                nums[curIdx] = nums[redPointer]; // swap
                nums[redPointer] = 0;
                redPointer++;
            }
            if (nums[curIdx] == 2) {
                // even we go into last if statement, we still need to check this
                nums[curIdx] = nums[bluePointer];
                nums[bluePointer] = 2;
                bluePointer--;
                curIdx--;
            }
            curIdx++;
        }
    }
}
