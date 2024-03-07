package Ex601_900.Ex873_LengthOfLongestFibonacciSubsequence;

/*
    Idea from LeetCode:
        if we let: a + b = c, the we use a 2d array:
        [b][c] to represent longest Fibonacci sequence length till c
        [b][c] = [a][b] + 1.

        Also, we can use 3-sum method here, because we wanna find: A + B == C in correct order
        of {A ... B ... C ...}
        we can let target = C: then keep finding ele from left to right and get A & B
 */

public class Solution {
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length < 3)
            return 0;

        int aLen = A.length;
        int[][] validFibLen = new int[aLen][aLen];
        int maxLen = 0;

        // 3-sum method
        for (int i = 2; i < aLen; i++) {
            int curTarget = A[i];
            int l = 0;
            int r = i - 1;
            // faster without this purning
//            int minSum = A[l] + A[l + 1];
//            if (minSum > curTarget)
//                continue;
//            int maxSum = A[r] + A[r - 1];
//            if (maxSum < curTarget)
//                continue;
            while (l < r) {
                int curSum = A[l] + A[r];
                if (curSum < curTarget) {
                    l++;
                } else if (curSum > curTarget) {
                    r--;
                } else { // curSum == curTarget
                    validFibLen[r][i] = validFibLen[l][r] + 1;
                    maxLen = Math.max(validFibLen[r][i], maxLen);
                    l++;
                    r--;
                }
            }
        }
        return maxLen == 0 ? 0 : maxLen + 2;
        // + 2 because we let a + b == c as 1, but it's 3 ele at all
    }
}
