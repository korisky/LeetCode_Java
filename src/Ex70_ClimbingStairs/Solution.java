package Ex70_ClimbingStairs;

/*
    Dynamic Programming Stuff
 */

public class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for (int index = 2; index <= n; index++)
            steps[index] = steps[index - 1] + steps[index - 2];
        return steps[n];
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.climbStairs(3));
    }
}
