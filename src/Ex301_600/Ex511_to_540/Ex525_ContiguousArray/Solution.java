package Ex301_600.Ex511_to_540.Ex525_ContiguousArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 由于题目限制, 值只有1和0, 将0全部置换为-1, 这个时候sum为0时, 就可以判断经过偶数对的1和0
     */
    public int findMaxLength(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        Map<Integer, Integer> sumToIdx = new HashMap<>();
        sumToIdx.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIdx.containsKey(sum)) {
                max = Math.max(max, i - sumToIdx.get(sum));
            } else {
                sumToIdx.put(sum, i);
            }
        }

        return max;
    }
}
