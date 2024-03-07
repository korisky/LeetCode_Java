package Ex1_300.Ex211_to_240.Ex215_KthLargestElementInArray;

/*
    Because we only need to find kth largest, we do not need
    to sort the whole array. We can use a priority queue and keep
    it's size == k, then peek the one would the the kth largest ele
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> theQueue = new PriorityQueue<>();
        for (int num : nums) {
            theQueue.add(num);
            if (theQueue.size() > k)
                theQueue.poll();
        }
        return theQueue.peek();
    }
}
