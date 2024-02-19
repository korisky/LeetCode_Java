package Ex61_to_90.Ex75_SortColors;

import java.util.Arrays;

public class AnotherSol {

    public static void main(String[] args) {
        int[] test1 = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(test1);
        System.out.println();
    }

    /**
     * 这个方法虽然可以排序, 但题目中的array是作为入参数, 所以无法使用Copy部分
     */
    public static void sortColors(int[] nums) {
        int[] ints = mergeSortDeprecate(nums);
        nums = ints;
        System.out.println();
    }

    public static int[] mergeSortDeprecate(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int[] left = mergeSortDeprecate(Arrays.copyOfRange(nums, 0, nums.length / 2));
        int[] right = mergeSortDeprecate(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
        return mergeDeprecate(left, right);
    }

    public static int[] mergeDeprecate(int[] left, int[] right) {
        int[] combine = new int[left.length + right.length];
        int l = 0, r = 0, idx = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                combine[idx++] = left[l++];
            } else {
                combine[idx++] = right[r++];
            }
        }
        while (l < left.length) {
            combine[idx++] = left[l++];
        }
        while (r < right.length) {
            combine[idx++] = right[r++];
        }
        return combine;
    }
}
