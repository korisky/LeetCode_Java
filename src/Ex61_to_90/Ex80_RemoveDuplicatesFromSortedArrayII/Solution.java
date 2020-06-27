package Ex61_to_90.Ex80_RemoveDuplicatesFromSortedArrayII;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int n : nums) {
            if (idx < 2 || n > nums[idx - 2])
                // because the number array is increasing, we can judge it by >
                nums[idx++] = n;
        }
        return idx;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
