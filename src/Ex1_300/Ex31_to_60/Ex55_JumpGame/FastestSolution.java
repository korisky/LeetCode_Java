package Ex1_300.Ex31_to_60.Ex55_JumpGame;

/*
    Idea also from LeetCode:
        We can do Regression Search, check from end
        If we can reach index 0, then must be true
 */

public class FastestSolution {
    public static boolean canJump(int[] nums) {
        int reachFromTail = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= reachFromTail)
                reachFromTail = i;
        }
        return reachFromTail == 0;
    }

    public static void main(String[] args) {
//        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{3, 2, 2, 0, 4}));
//        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
