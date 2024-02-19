package Ex61_to_90.Ex75_SortColors;

import java.util.Arrays;

public class AnotherSol {

    public static void main(String[] args) {
        int[] test1 = new int[]{2, 0, 2, 1, 1, 0};
        mergeSort(test1, 0, test1.length - 1);
        System.out.println();
    }

    /**
     * 针对Array, 使用的MergeSort应该做swap操作, 要用带idx的方式
     */
    public static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            // 记住这个地方是求和, 而不是相减
            int mid = (end + start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public static void merge(int[] nums, int start, int mid, int end) {

        // merge部分, 需要注意array与链表不同, 这里的是index, 需要用等于
        // 另外l和r也不同, 需要提前指向头与中部
        int[] combine = new int[end - start + 1];
        int idx = 0, l = start, r = mid + 1;
        while (l <= mid && r <= end) {
            combine[idx++] = (nums[l] <= nums[r])
                    ? nums[l++] : nums[r++];
//            if (nums[l] <= nums[r]) {
//                combine[idx++] = nums[l++];
//            } else {
//                combine[idx++] = nums[r++];
//            }
        }
        while (l <= mid) {
            combine[idx++] = nums[l++];
        }
        while (r <= end) {
            combine[idx++] = nums[r++];
        }

        // 复制回去原来的array
        for (int i = 0; i < idx; i++) {
            nums[i + start] = combine[i];
        }
    }


    /**
     * 这个方法虽然可以排序, 但题目中的array是作为入参数, 所以无法使用Copy部分
     */
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
