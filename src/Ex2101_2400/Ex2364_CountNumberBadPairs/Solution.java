package Ex2101_2400.Ex2364_CountNumberBadPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public long countBadPairs(int[] nums) {
        long badPairs = 0;
        Map<Integer, Integer> diffCount = new HashMap<>();
        for (int pos = 0; pos < nums.length; pos++) {
            int diff = pos - nums[pos];
            int goodParisCount = diffCount.getOrDefault(diff, 0);
            badPairs += pos - goodParisCount;
            diffCount.put(diff, goodParisCount + 1);
        }
        return badPairs;
    }
}
