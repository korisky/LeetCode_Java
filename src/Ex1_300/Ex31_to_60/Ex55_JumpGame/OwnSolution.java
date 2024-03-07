package Ex1_300.Ex31_to_60.Ex55_JumpGame;

/*
    Too slow for execution
 */

public class OwnSolution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        else
            return doJumpping(nums, 0);
    }

    public boolean doJumpping(int[] nums, int curPos) {
        if (curPos == nums.length - 1)
            return true;
        else if (curPos > nums.length - 1)
            return false;

        int maxJump = nums[curPos];
        for (int jumpStep = 1; jumpStep <= maxJump; jumpStep++) {
            if (doJumpping(nums, curPos + jumpStep))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OwnSolution use = new OwnSolution();

        int[] test_can = new int[]{2,3,1,1,4};
        System.out.println(use.canJump(test_can));

        int[] test_cannot = new int[]{3,2,1,0,4};
        System.out.println(use.canJump(test_cannot));
    }
}
