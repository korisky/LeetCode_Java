package Ex1_300.Ex1_to_30.Ex16_3SumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int dif = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int curLeft = nums[i];
            int mid = i + 1;
            int right = nums.length - 1;

            int minSum = curLeft + nums[mid] + nums[mid + 1];
            if (minSum > target) {
                if (Math.abs(target - minSum) < Math.abs(dif))
                    dif = target - minSum;
                break;
            }

            int maxSum = curLeft + nums[right - 1] + nums[right];
            if (maxSum < target) {
                if (Math.abs(target - maxSum) < Math.abs(dif))
                    dif = target - maxSum;
                continue;
            }

            while (mid < right) {
                int curSum = curLeft + nums[mid] + nums[right];
                if (curSum == target)
                    return target;
                else if (curSum < target) {
                    mid++;
                    while (mid < right && nums[mid] == nums[mid - 1])
                        mid++;
                } else {
                    right--;
                    while (mid < right && nums[right] == nums[right + 1])
                        right--;
                }
                if (Math.abs(target - curSum) < Math.abs(dif))
                    dif = target - curSum;
            }
        }
        return target - dif;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
