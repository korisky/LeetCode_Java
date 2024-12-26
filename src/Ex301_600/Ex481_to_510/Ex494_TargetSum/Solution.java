package Ex301_600.Ex481_to_510.Ex494_TargetSum;

/**
 * Brute-force method -> go through all possibilities
 */
public class Solution {


    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        calculateWays(nums, 0, 0, target);
        return totalWays;
    }

    private void calculateWays(int[] nums, int curIdx, int curSum, int target) {
        // max idx
        if (curIdx == nums.length) {
            // check if current sum just match the target
            if (curSum == target) {
                totalWays++;
            }
            // idx exceed
            return;
        }
        // include current number with positive sign
        calculateWays(nums, curIdx + 1, curSum + nums[curIdx], target);
        // include current number with negative sign
        calculateWays(nums, curIdx + 1, curSum - nums[curIdx], target);
    }
}
