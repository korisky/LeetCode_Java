package Ex1_300.Ex121_to_150.Ex128_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * 因为是找到最长连续的数组的长度, 实际上我们只需要找到数组的一端, 然后持续的去向另一端扩展, 即可找到最长的长度
 */
public class SetSolution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> remainingSet = new HashSet<>();
        for (int num : nums) {
            remainingSet.add(num);
        }
        int globalMax = 0;
        for (int num : nums) {
            int maxLen = 1;
            if (!remainingSet.contains(num - 1)) {
                while (remainingSet.contains(num + 1)) {
                    remainingSet.remove(num + 1);
                    num = num + 1;
                    maxLen++;
                }
            }
            globalMax = Math.max(globalMax, maxLen);
        }
        return globalMax;
    }
}
