package Ex31_to_60.Ex55_JumpGame;

/*
Idea from LeetCode:
    The nature of the Question should be focusing on : how far could we reach from each slot.
    We can keep holding a Pointer to represent the outermost (farthest) index while traversing.
    If we find that current position's index is greater than the farthest index we could reach,
    we could just return FALSE.
 */

public class FasterSolution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > farthest)
                return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}
