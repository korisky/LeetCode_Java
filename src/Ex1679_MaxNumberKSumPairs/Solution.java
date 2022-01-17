package Ex1679_MaxNumberKSumPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int ops = 0;
        Map<Integer, Integer> freMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curVal = nums[i];
            if (freMap.containsKey(curVal)) {
                Integer fre = freMap.get(curVal);
                if (fre == 1) {
                    freMap.remove(curVal);
                } else {
                    freMap.put(curVal, fre - 1);
                }
                // add
                ops++;
            } else {
                freMap.put(k - curVal, freMap.getOrDefault(k - curVal, 0) + 1);
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        System.out.println(s.maxOperations(test, 3));
    }
}
