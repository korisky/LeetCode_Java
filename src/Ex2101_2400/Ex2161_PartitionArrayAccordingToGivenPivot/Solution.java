package Ex2101_2400.Ex2161_PartitionArrayAccordingToGivenPivot;

public class Solution {

    /**
     * 双指针法 -> 实际上是一次遍历, 从2个方向进行内容填补, 最后仍无法填满的一定是跟pivot相同
     */
    public static int[] pivotArray(int[] nums, int pivot) {

        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;

        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                result[left] = nums[i];
                left++;
            }

            if (nums[j] > pivot) {
                result[right] = nums[j];
                right--;
            }
        }

        while (left <= right) {
            result[left] = pivot;
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10);
    }
}
