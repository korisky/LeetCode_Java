package Ex601_900.Ex992_SubarraysKDifferentIntegers;

public class Solution {


    /**
     * 与2962, 2958这些问题近似, 但这里我们直接对k进行操作, 当它为0时, 就是刚好维持k个distinctArray的情况
     */
    public static int subarraysWithKDistinct(int[] nums, int k) {

        int[] unqCount = new int[nums.length + 1];

        int totalCount = 0, left = 0, right = 0, currCount = 0;

        while (right < nums.length) {
            if (unqCount[nums[right++]]++ == 0) {
                k--;
            }
            if (k < 0) {
                --unqCount[nums[left]];
                left++;
                k++;
                currCount = 0;
            }
            if (k == 0) {
                while (unqCount[nums[left]] > 1) {
                    --unqCount[nums[left]];
                    left++;
                    currCount++;
                }
                totalCount += currCount + 1;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
    }
}
