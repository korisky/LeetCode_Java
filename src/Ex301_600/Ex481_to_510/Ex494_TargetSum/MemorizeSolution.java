package Ex301_600.Ex481_to_510.Ex494_TargetSum;

import java.util.Arrays;

/**
 * For sub-problems, we repeatedly calculated.
 * Try to use an 2d-array to store the results
 */
public class MemorizeSolution {

    int totalSum = 0;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculateWays(nums, 0, 0, target, memo);
    }


    private int calculateWays(int[] nums, int curIdx, int curSum, int target, int[][] memo) {

        // reach the bound
        if (curIdx == nums.length) {
            if (curSum == target) {
                return 1;
            } else {
                return 0;
            }
            // returned
        }

        // check calculated before or not
        if (memo[curIdx][curSum + totalSum] != Integer.MIN_VALUE) {
            // calculated before
            return memo[curIdx][curSum + totalSum];
        }

        // need to calculate
        int add = calculateWays(nums, curIdx + 1, curSum + nums[curIdx], target, memo);
        int subtract = calculateWays(nums, curIdx + 1, curSum - nums[curIdx], target, memo);

        // remember the result
        memo[curIdx][curSum + totalSum] = add + subtract;

        return memo[curIdx][curSum + totalSum];
    }

}
