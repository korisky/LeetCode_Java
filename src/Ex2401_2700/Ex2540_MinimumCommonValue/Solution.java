package Ex2401_2700.Ex2540_MinimumCommonValue;

public class Solution {

    /**
     * 两个非递减的数组, 返回两个数组都包含的最小元素
     */
    public static int getCommon(int[] nums1, int[] nums2) {
        // 额外加速判断
        if (nums1[nums1.length - 1] < nums2[0] || nums2[nums2.length - 1] < nums1[0]) {
            return -1;
        }
        // 双指针
        int l = 0, r = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] == nums2[r]) {
                return nums1[l];
            } else if (nums1[l] < nums2[r]) {
                l++;
            } else if (nums1[l] > nums2[r]) {
                r++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{2, 6, 7, 9, 100};
        System.out.println(getCommon(nums1, nums2));
    }
}
