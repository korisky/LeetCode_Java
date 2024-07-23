package Ex1501_1800.Ex1636_SortArrayByIncreasingFrequency;

public class Solution {

    /**
     * 使用快排
     */
    public int[] frequencySort(int[] nums) {
        int[] count = new int[202];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 100]++;
        }
        quickSort(nums, count, 0, nums.length - 1);
        return nums;
    }


    private void quickSort(int[] nums, int freq[], int low, int high) {
        if (low < high) {
            int pivot = partition(nums, freq, low, high);
            quickSort(nums, freq, low, pivot - 1);
            quickSort(nums, freq, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int freq[], int low, int high) {
        int pivot = freq[nums[high] + 100];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (pivot > freq[nums[j] + 100]) {
                i++;
                swap(nums, i, j);
            } else if (pivot == freq[nums[j] + 100]) {
                if (nums[high] <= nums[j]) {
                    i++;
                    swap(nums, i, j);
                }

            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
