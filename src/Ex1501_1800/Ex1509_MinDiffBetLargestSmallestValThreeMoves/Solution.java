package Ex1501_1800.Ex1509_MinDiffBetLargestSmallestValThreeMoves;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    /**
     * 题目要求移动3步达到max-min更小, 核心在于修改max和min之间的元素是不影响的,
     * 我们要使用类似贪心算法的方式, 持续找到max和min
     */
    public static int minDifference(int[] nums) {

        // 小于4个元素可以直接返回0
        int numSize = nums.length;
        if (numSize <= 4) {
            return 0;
        }

        // 只维持最小的4个
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
        }
        List<Integer> minFour = new ArrayList<>(maxHeap);
        Collections.sort(minFour);

        // 只维持最大的4个
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
        }
        List<Integer> maxFour = new ArrayList<>(minHeap);
        Collections.sort(maxFour);

        // 这里寻找4对, 找到差值最小的一个
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(minDiff, maxFour.get(i) - minFour.get(i));
        }
        return minDiff;
    }

    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{1, 5, 0, 10, 4}));
    }
}
