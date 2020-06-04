package EX31_to_60.Ex53_MaximumSubarray;

public class OwnSolution {
    public int maxSubArray(int[] nums) {

        // Using Kadane's Algorithm

        int globalMax;
        int[] maxValEndOnCurIndex = new int[nums.length];
        maxValEndOnCurIndex[0] = globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxValEndOnCurIndex[i] = Math.max(nums[i], nums[i] + maxValEndOnCurIndex[i - 1]);
            if (maxValEndOnCurIndex[i] > globalMax)
                globalMax = maxValEndOnCurIndex[i];
        }

        return globalMax;
    }
}
