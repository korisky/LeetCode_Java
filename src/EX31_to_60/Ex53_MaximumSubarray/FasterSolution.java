package EX31_to_60.Ex53_MaximumSubarray;

public class FasterSolution {
    public int maxSubArray(int[] nums) {

        int globalMax = nums[0];
        int lastMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            lastMax = Math.max(nums[i], nums[i] + lastMax);
            if (lastMax > globalMax)
                globalMax = lastMax;
        }

        return globalMax;
    }
}
