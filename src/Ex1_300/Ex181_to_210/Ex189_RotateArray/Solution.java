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

    /**
     * V1 版本使用3个旋转, 该V2版本则使用取模的概念, 可以重新放置
     */
    public void rotateV2(int[] nums, int k) {
        // 取模放置
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[(i + k) % nums.length] = nums[i];
        }
        // 复制回原数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
    }
}
