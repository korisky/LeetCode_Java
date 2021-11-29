package Ex169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class FreqMapSolution {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            // adding frequency and put into map
            Integer curNumFreq = freq.getOrDefault(nums[i], 0) + 1;
            freq.put(nums[i], curNumFreq);
            if (maxFreq < curNumFreq) {
                maxFreq = curNumFreq;
                maxNum = nums[i];
            }
            // faster implementation
            if (maxFreq > nums.length / 2) {
                break;
            }
        }
        return maxNum;
    }

}
