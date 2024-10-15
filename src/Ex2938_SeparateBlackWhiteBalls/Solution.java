package Ex2938_SeparateBlackWhiteBalls;

public class Solution {


    /**
     * 题目核心在于理解, 假定左边放白球右边黑球, 那么从左到右遍历, 遇到黑球时+1, 而一旦遇到白球, 则将+1的值记下即可
     */
    public long minimumSteps(String s) {
        long totalSwap = 0;
        int blackBallCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                // 遇到黑球进行记录即可
                blackBallCount++;
            } else {
                // 一旦遇到白球, 则一定要将左边已经存在的黑球都算入需要swap的数目
                // 并且不能重置
                totalSwap += blackBallCount;
            }
        }
        return totalSwap;
    }
}
