package Ex135_Candy;

import java.util.Arrays;

/**
 * Simple approach considering the 'water tank' problem, by 'scan' the array from left 2 right, and right 2 left
 */
public class Solution {
    public int candy(int[] ratings) {
        if (null == ratings || ratings.length <= 0) {
            return 0;
        }
        int res = 0;
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        // left 2 right
        for (int i = 1; i < len; i++) {
            // for left
            if (ratings[i] > ratings[i - 1]) {
                // must add 1 candy
                left[i] = left[i - 1] + 1;
            }
            // for right
            int rIdx = len - 1 - i;
            if (ratings[rIdx + 1] < ratings[rIdx]) {
                // must add 1 candy
                right[rIdx] = right[rIdx + 1] + 1;
            }
        }
        // get max and sum them all
        for (int i = 0; i < len; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] test = new int[]{5, 3, 2, 1, 2, 6, 5, 4, 4, 7};
        int[] test = new int[]{1, 2, 2};
        int candy = s.candy(test);
        System.out.println(candy);
    }
}
