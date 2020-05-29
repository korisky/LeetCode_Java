package Ex377_CombinationSumIV;

import java.util.Arrays;

// too slow

public class Solution {
    private int results;
    public int combinationSum4(int[] nums, int target) {
        results = 0;
        Arrays.sort(nums);
        dfsGetComb(nums, 0, nums.length - 1, target);
        return results;
    }

    public void dfsGetComb(int[] nums, int start, int end, int target) {
        if (target == 0) {
            results++;
        } else if (target > 0) {
            for (int curIndex = start; curIndex <= end; curIndex++) {
                if (nums[curIndex] > target)
                    break;
                dfsGetComb(nums, start, end, target - nums[curIndex]);
            }
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.combinationSum4(new int[]{2, 1, 3}, 35));
    }
}
