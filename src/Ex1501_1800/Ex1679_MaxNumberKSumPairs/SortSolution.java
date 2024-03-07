package Ex1501_1800.Ex1679_MaxNumberKSumPairs;

import java.util.Arrays;

public class SortSolution {
    public int maxOperations(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int ops = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                ops++;
                left++;
                right--;
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        SortSolution s = new SortSolution();
        int[] test = new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        System.out.println(s.maxOperations(test, 3));
    }
}
