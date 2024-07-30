package Ex1501_1800.Ex1653_MinimumDeletionsMakeStringBalanced;

public class Solution {

    /**
     * Similar to Ex926 -> Flip Str to Monotone increasing
     * A string is considered "balanced" if there are no 'a'
     * characters present after any 'b' characters.
     */
    public int minimumDeletions(String s) {
        int cntb = 0, res = 0;
        for (char x : s.toCharArray()) {
            if (x == 'a') {
                res = Math.min(++res, cntb);
            } else if (x == 'b') {
                ++cntb;
            }
        }
        return res;
    }
}
