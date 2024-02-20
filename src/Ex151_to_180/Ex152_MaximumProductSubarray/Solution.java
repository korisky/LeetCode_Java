package Ex151_to_180.Ex152_MaximumProductSubarray;

/**
 * 由于存在负数, 但是负负得正, 所以我们要同时把最大和最小(负数)都要保存下来, 并且每次都进行比较
 * 比较: nums[i], max * nums[i], min * nums[i]
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int minTempProduct = nums[0];
        int maxTempProduct = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxTemp = maxTempProduct;
            int minTemp = minTempProduct;
            maxTempProduct = Math.max(nums[i], Math.max(nums[i] * maxTemp, nums[i] * minTemp));
            minTempProduct = Math.min(nums[i], Math.min(nums[i] * maxTemp, nums[i] * minTemp));
            if (maxTempProduct > globalMax) {
                globalMax = maxTempProduct;
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] test = new int[]{-2, 3, -4};
        System.out.println(s.maxProduct(test));

    }
}
