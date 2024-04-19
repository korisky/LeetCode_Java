package Ex901_1200.Ex1044_LongestDuplicateSubstring;

import java.util.HashSet;

public class Solution {

    /**
     * Binary Search + Rabin-Karp algorithm
     */
    public String longestDupSubstring(String s) {

        int left = 1;
        int right = s.length();
        long mods = (long) Math.pow(2, 32);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (searchForLen(s, mid, mods) != -1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = searchForLen(s, left - 1, mods);
        return start != -1 ? s.substring(start, start + left - 1) : "";
    }

    private static int searchForLen(String s, int len, long mods) {
        if (len == 0) {
            return -1;
        }
        long h = 0;
        long aL = 1;
        for (int i = 0; i < len; i++) {
            h = (h * 26 + (s.charAt(i) - 'a')) % mods;
            aL = (aL * 26) % mods;
        }

        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        for (int start = 1; start < s.length() - len + 1; start++) {
            h = (h * 26 - (s.charAt(start - 1) - 'a') * aL % mods + mods) % mods;
            h = (h + (s.charAt(start + len - 1) - 'a')) % mods;
            if (seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }
}
