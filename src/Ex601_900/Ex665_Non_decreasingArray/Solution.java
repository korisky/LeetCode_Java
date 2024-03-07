package Ex601_900.Ex665_Non_decreasingArray;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int changeTime = 0;
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx - 1] > nums[idx]) {
                if (changeTime++ > 0)
                    return false;
                if (idx - 2 < 0 || nums[idx - 2] <= nums[idx])
                    nums[idx - 1] = nums[idx];
                else
                    nums[idx] = nums[idx - 1];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{3, 4, 2, 3};
        System.out.println(use.checkPossibility(test));
    }
}
