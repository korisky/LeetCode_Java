package Ex239_SlidingWindowMaximum;

/*
    We could use a Deque to store the index of current maximum
    each time we add a number in Deque, we need to check whether any element
    int Deque is less than this num, if there is, we need to delete all of them,
    but, we just ignore the one is greater than current input.

    Then we can make sure that the first element in the Deque would be the maximum value

    The procedure would be:
        1) check the first element in Deque's index, if it's out of window, we need to pop it out
        2) go and check whether current element's value is greater than any element's value in the Deque
        If there exists, we need to delete all of them. It would be a little bit quicker, if we delete
        the elements from last of the queue.
        3) Then we can add the new element's index into the Deque
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length)
            return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int idx = 0; idx < nums.length; idx++) {
            // here should be length of searching array, because we handle
            // the idx < k - 1, would not be added into the array

            // 1. handle the stuff in the deque
            if (!deque.isEmpty() && deque.peekFirst() <= idx - k)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[idx])
                deque.pollLast();

            deque.offerLast(idx);

            // 2. add the local-maximum into the result array
            if (idx >= k - 1)
                // e.g. k = 3, idx = 0, we should add nothing
                // we should add stuff only after first window's size
                res[idx - k + 1] = nums[deque.peekFirst()];

        }
        return res;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = use.maxSlidingWindow(test, 3);
        for (int i : res)
            System.out.println(i);
    }
}
