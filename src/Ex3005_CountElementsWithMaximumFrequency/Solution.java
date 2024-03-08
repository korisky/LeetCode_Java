package Ex3005_CountElementsWithMaximumFrequency;

public class Solution {
    /**
     * 1 <= nums[i] <= 100, nums.length <= 100
     */
    public static int maxFrequencyElements(int[] nums) {
        // 1) 遍历统计频次, 并记录最高频次
        int maxFreq = Integer.MIN_VALUE;
        int[] freq = new int[100];
        for (int num : nums) {
            freq[num - 1]++;
            maxFreq = Math.max(maxFreq, freq[num - 1]);
        }
        // 2) 找到最高频次出现次数
        int times = 0;
        for (int curFreq : freq) {
            if (curFreq == maxFreq) {
                times++;
            }
        }
        return times * maxFreq;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 2, 3, 1, 4};
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxFrequencyElements(arr));
    }
}
