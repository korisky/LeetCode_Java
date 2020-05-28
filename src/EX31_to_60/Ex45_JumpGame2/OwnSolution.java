package EX31_to_60.Ex45_JumpGame2;

/*
    Stair + Ladder Idea from https://www.youtube.com/watch?v=vBdo7wtwlXs
 */

public class OwnSolution {
    public int jump(int[] nums) {

        if (nums == null || nums.length <= 1)
            return 0;

        int ladder = nums[0]; // the ladder we could use to 'climb' to upper stairs
        int stairs = nums[0]; // the stairs we can still climbing with the ladder
        int jump = 1;

        for (int level = 1; level < nums.length; level++) {
            if (level == nums.length - 1) // means the ladder is just reached the end point
                return jump;
            if (level + nums[level] > ladder) // keep 'Changing' the ladder with the one that can reach
                                              // the highest level (no matter it's length)
                ladder = level + nums[level];
            stairs--; // every time we must climb up stairs
            if (stairs == 0) { // means all ladder we use would end up at this point
                                // we have to use current point (the top stair of ladder's level)
                jump++;
                stairs = ladder - level;
            }
        }
        return jump;
    }
}
