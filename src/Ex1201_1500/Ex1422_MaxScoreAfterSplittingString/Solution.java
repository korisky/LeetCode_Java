package Ex1201_1500.Ex1422_MaxScoreAfterSplittingString;

public class Solution {

    /**
     * 由于目标就是从左到右切分2个slice, 计算左边的0跟右边的1的数量和
     * score = Zero_L + One_R
     * = Zero_L + One_Total - One_Left
     * 由于 One_Total 是固定值, 我们需要找到的是 Zero_L - One_Left 的最大值
     */
    public int maxScore(String s) {
        int ones = 0;
        int zeros = 0;
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }
            best = Math.max(best, zeros - ones);
        }

        // 针对最后一位单独处理, 由于我们必须要切分2份, 遍历的i不能到最后一位
        if (s.charAt(s.length() - 1) == '1') {
            ones++;
        }
        return best + ones;
    }
}
