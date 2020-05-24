package Ex1_to_30.Ex18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Just really similar to the Three sum closest, but also really fast
 */

public class fourSum_S {
    private List<List<Integer>> combins;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4)
            return new ArrayList<>();
        combins = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            threeSum(nums, i + 1, target - nums[i]);
        }
        return combins;
    }

    public void threeSum(int[] nums, int startIndex, int sum_target) {
        for (int leftIndex = startIndex; leftIndex < nums.length - 2; leftIndex++) {
            if (leftIndex > startIndex && nums[leftIndex] == nums[leftIndex - 1])
                continue;
            int curLeftVal = nums[leftIndex];
            int midIndex = leftIndex + 1;
            int rightIndex = nums.length - 1;
            int minSum = curLeftVal + nums[midIndex] + nums[midIndex + 1];
            if (minSum > sum_target)
                break;
            int maxSum = curLeftVal + nums[rightIndex - 1] + nums[rightIndex];
            if (maxSum < sum_target)
                continue;
            while (midIndex < rightIndex) {
                int curSum = curLeftVal + nums[midIndex] + nums[rightIndex];
                if (curSum == sum_target) {
                    combins.add(Arrays.asList(nums[startIndex - 1], curLeftVal,
                            nums[midIndex], nums[rightIndex]));
                    rightIndex--;
                    while (midIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1])
                        rightIndex--;
                } else if (curSum < sum_target) {
                    midIndex++;
                    while (midIndex < rightIndex && nums[midIndex] == nums[midIndex - 1])
                        midIndex++;
                } else {
                    rightIndex--;
                    while (midIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1])
                        rightIndex--;
                }
            }
        }
    }

    public static void main(String[] args) {
        fourSum_S use = new fourSum_S();
        System.out.println(use.fourSum(new int[]{5, 5, 3, 5, 1, -5, 1, -2}, 4));
    }
}
