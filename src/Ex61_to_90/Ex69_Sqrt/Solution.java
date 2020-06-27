package Ex61_to_90.Ex69_Sqrt;

/*
    Idea from LeetCode, use Binary Search
 */

public class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        long middle;

        while (l <= r) { // Remember, we need to set l <= r, not just l < r.
                        // Then we could find out the exactly index we need
            middle = ((long)l + (long)r) / 2;
            long mPow = middle * middle;
            if (mPow == x)
                return (int) middle;
            else if (mPow < x) {
                l = (int) middle + 1;
            } else {
                r = (int) middle - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int test = 16;
        System.out.println(use.mySqrt(test));
    }
}
