package Ex1_300.Ex181_to_210.Ex189_RotateArray;

/*
    Idea form LeetCode:
        we can use three reverse to get what we want
 */

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
    }
}
