package Ex901_1200.Ex912_SortArray;

public class Solution {

    public static void main(String[] args) {
        int[] intArr = sortArray(new int[]{0, 4, 5, 1, 3, 2});
        for (int anInt : intArr) {
            System.out.println(anInt);
        }
    }


    /**
     * 选择使用最稳定且性能和空间较为平衡的 MergeSort 实现
     */
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            mergeOne(nums, start, mid, end);
        }
    }


    private static void mergeOne(int[] nums, int start, int mid, int end) {
        int[] extra = new int[end - start + 1];
        int i = 0;
        int l = start;
        int r = mid + 1;
        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                extra[i++] = nums[l++];
            } else {
                extra[i++] = nums[r++];
            }
        }
        while (l <= mid) {
            extra[i++] = nums[l++];
        }
        while (r <= end) {
            extra[i++] = nums[r++];
        }
        // copy back
        System.arraycopy(extra, 0, nums, start, extra.length);
    }
}
