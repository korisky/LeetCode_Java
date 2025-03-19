package Ex3191_MinimumOperations2MakeBinaryArrayElementsEqual2OneI;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int minOperations(int[] nums) {
        Deque<Integer> flipQueue = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!flipQueue.isEmpty() && i > flipQueue.peekFirst() + 2) {
                flipQueue.pollFirst();
            }
            if ((nums[i] + flipQueue.size()) % 2 == 0) {
                if (i + 2 >= nums.length) {
                    return -1;
                }
                count++;
                flipQueue.offerLast(i);
            }
        }
        return count;
    }

    public int minOperations_Faster(int[] nums) {
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] == 0) {
                count++;
                nums[i - 2] = nums[i - 2] ^ 1;
                nums[i - 1] = nums[i - 1] ^ 1;
                nums[i] = nums[i] ^ 1;
            }
        }
        // check remaining are all 1 or not
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum == nums.length ? count : -1;
    }
}
