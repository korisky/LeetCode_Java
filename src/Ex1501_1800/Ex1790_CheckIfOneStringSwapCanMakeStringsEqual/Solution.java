package Ex1501_1800.Ex1790_CheckIfOneStringSwapCanMakeStringsEqual;

public class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        int firstIdxDif = 0;
        int secondIdxDif = 0;
        int numDiffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numDiffs++;
                if (numDiffs > 2) {
                    return false;
                } else if (numDiffs == 1) {
                    firstIdxDif = i;
                } else {
                    secondIdxDif = i;
                }
            }
        }
        return s1.charAt(firstIdxDif) == s2.charAt(secondIdxDif)
                && s1.charAt(secondIdxDif) == s2.charAt(firstIdxDif);
    }
}
