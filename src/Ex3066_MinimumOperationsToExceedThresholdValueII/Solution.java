package Ex3066_MinimumOperationsToExceedThresholdValueII;

import java.util.PriorityQueue;

public class Solution {

    /**
     * 每次找到最小的两个数进行修正, 使得所有数都>k
     */
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            queue.offer(Long.valueOf(num));
        }

        int ops = 0;
        while (queue.peek().compareTo((long) k) < 0) {
            Long p1 = queue.poll();
            Long p2 = queue.poll();
            queue.offer(Math.min(p1, p2) * 2 + Math.max(p1, p2));
            ops++;
        }

        return ops;
    }
}
