package Ex601_900.Ex719_FindKthSmallestPairDistance;

import java.util.*;

public class Solution {

    /**
     * Binary Search + 区间
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = nums.length;
        // Init binary search range
        int low = 0;
        int high = nums[arraySize - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;
            int count = countPairsWithMaxDistance(nums, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countPairsWithMaxDistance(int[] nums, int maxDistance) {
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDistance) {
                left++;
            }
            count += right - left;
        }
        return count;
    }

}
