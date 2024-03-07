package Ex1_300.Ex31_to_60.Ex53_MaximumSubarray;

/**
 * 因为是和最大的连续数组, 所以每次需要比较是否需要重新开始新数组,
 * 就是比较 当前值 和 前面数组+当前值 这两个谁更大， 选择最大的那个即可
 */
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
