package Ex55_JumpGame;

/*
    Idea also from LeetCode:
        We can do Regression Search, check from end
        If we can reach index 0, then must be true
 */

public class FastestSolution {
    public boolean canJump(int[] nums) {
        int reachFromTail = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= reachFromTail)
                reachFromTail = i;
        }
        return reachFromTail == 0;
    }
}
