package Ex76_MinimumWindowSubstring;

/*
    All substring problem can use this template: (substring problem means we need to find a continuous substring)
        1) set up two pointer, both point to 0, represent the substring we need to find
            's start and end index respectively.
        2) get the frequency array of one string (or under some problem)
        3) while (end < total length)
        4) do some stuff to modify the frequency map
        5) while (some condition), then we modify the condition that can get out this inner loop


    The steps for solving this problem:
    1. Use two pointers: start and end to represent a window.
    2. Move end to find a valid window.
    3. When a valid window is found, move start to find a smaller window.
 */

public class Solution {
    public String minWindow(String s, String t) {
        int[] freqArr = new int[128];
        for (char c : t.toCharArray())
            freqArr[c]++;

        int start = 0, end = 0, minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int lenRemain = t.length();
        char[] sChars = s.toCharArray();

        while (end < sChars.length) {
            char curChar = sChars[end];
            if (freqArr[curChar] > 0)
                lenRemain--; // that means we meet a char that is in target string
            // we should minus the length of remaining
            freqArr[curChar]--; // we always need to minus it, the char that is not in target string, would
            // contain < 0
            end++; // keep moving to right

            while (lenRemain == 0) { // we only meet this situation, when we meet all char that the target
                // string contains
                if (end - start < minLen) { // keep finding the biggest start index
                    minLen = end - start;
                    minStart = start;
                }
                char startChar = sChars[start]; // we want to move the start index to right
                freqArr[startChar]++; // add it without any stuff
                if (freqArr[startChar] > 0) // for the other char that is not contained in target string
                    // it would only sum up to 0, but the one in the target string would > 0
                    lenRemain++; // that means, we can keep going to 'move right'
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
