package Ex153_FindMinimumRotatedSortedArray;


import java.util.Arrays;

/**
 * 标准的一个divide & conquer 的分治问题, 这里用二分法进行查询
 * 时间复杂度是log2(nums.len), 没有明确的空间复杂度
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int leftMin = findMin(Arrays.copyOfRange(nums, 0, nums.length / 2));
        int rightMin = findMin(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{11, 13, 15, 17};
        System.out.println(s.findMin(test));
    }

}
