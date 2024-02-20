package Ex151_to_180.Ex164_MaximumGap;

import java.util.Arrays;

/**
 * 使用桶排序实现, 将数字分到不同的桶中, 桶之内的gap一定<=桶本身的范围,
 * 而如果有empty bucket, 则可以保证max gap一定在这里
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        // find min and max first, for calculating how much bucket we need
        int lenIdx = nums.length - 1;
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // find the feasible interval for buckets
        int interval = (int) Math.ceil((double) (max - min) / lenIdx);
        int[] bucketsMin = new int[lenIdx];
        int[] bucketsMax = new int[lenIdx];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        // put into correct bucket
        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            // by using the interval to split numbers into correct bucket
            int idx = (num - min) / interval;
            // only record the maximum and minimum of each bucket
            bucketsMin[idx] = Math.min(bucketsMin[idx], num);
            bucketsMax[idx] = Math.max(bucketsMax[idx], num);
        }
        // find the maximum gap
        int maxGap = Integer.MIN_VALUE;
        int prev = min;
        for (int i = 0; i < lenIdx; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) {
                // empty bucket
                continue;
            }
            // record the gap
            maxGap = Math.max(maxGap, bucketsMin[i] - prev);
            prev = bucketsMax[i];
        }
        // for last bucket
        return Math.max(maxGap, max - prev);
    }
}
