package Ex2101_2400.Ex2342_MaxSumOfPairWithEqualSumDigits;

import java.util.PriorityQueue;

public class Solution {

    public int maximumSum(int[] nums) {

        PriorityQueue<Integer>[] digitSumGroups = new PriorityQueue[82];
        for (int i = 0; i < 82; i++) {
            digitSumGroups[i] = new PriorityQueue<>();
        }

        int maxPairSum = -1;
        for (int num : nums) {
            int digitSum = calculateDigitSum(num);
            digitSumGroups[digitSum].add(num);

            if (digitSumGroups[digitSum].size() > 2) {
                digitSumGroups[digitSum].poll();
            }
        }

        for (PriorityQueue<Integer> minHeap : digitSumGroups) {
            if (minHeap.size() == 2) {
                int first = minHeap.poll();
                int second = minHeap.poll();
                maxPairSum = Math.max(maxPairSum, first + second);
            }
        }

        return maxPairSum;
    }

    private int calculateDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }
}
