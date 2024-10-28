package Ex2501_LongestSquareStreakInArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int longestSquareStreak(int[] nums) {
        // store
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // go for all of them
        int maxLen = 0;
        for (int num : nums) {
            int len = 0;
            long nxt = num; // must use long
            while (set.contains((int) nxt)) {
                len++;
                // must use break, or else overflow
                if (nxt * nxt > 1e5) {
                    break;
                }
                nxt *= nxt;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen < 2 ? -1 : maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2}));
        System.out.println(longestSquareStreak(new int[]{2, 3, 5, 6, 7}));
        System.out.println(longestSquareStreak(new int[]{2, 4}));
        System.out.println(longestSquareStreak(new int[]{3, 9, 81, 6561}));
    }
}
