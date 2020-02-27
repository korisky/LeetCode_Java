package Ex18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum_S {
    private List<List<Integer>> results;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        results = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return results;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int curFirstVal = nums[i];
            if (i > 0 && curFirstVal == nums[i - 1])
                continue;
            threeSum(nums, target, i);
        }
        return results;
    }
    public void threeSum(int[] nums, int target, int starter) {
        int curTarget = target - nums[starter];
        for (int i = starter + 1; i < nums.length - 2; i++) {
            int leftVal = nums[i];
            if (i > starter + 1 && leftVal == nums[i - 1])
                continue;
            int mid = i + 1;
            int right = nums.length - 1;
            int minSum = leftVal + nums[mid] + nums[mid + 1];
            if (minSum > curTarget)
                break;
            int maxSum = leftVal + nums[right - 1] + nums[right];
            if (maxSum < curTarget)
                continue;
            while (mid < right) {
                int midVal = nums[mid];
                int rightVal = nums[right];
                int curSum = leftVal + midVal + rightVal;
                if (curSum == curTarget) {
                    results.add(Arrays.asList(nums[starter], leftVal, midVal, rightVal));
                    right--;
                    while (mid < right && nums[right] == nums[right + 1])
                        right--;
                } else if (curSum < curTarget) {
                    mid++;
                    while (mid < right && nums[mid] == nums[mid - 1])
                        mid++;
                } else {
                    right--;
                    while (mid < right && nums[right] == nums[right + 1])
                        right--;
                }
            }
        }
    }


    public static void main(String[] args) {
        fourSum_S use = new fourSum_S();
        System.out.println(use.fourSum(new int[]{5,5,3,5,1,-5,1,-2}, 4));
    }
}
