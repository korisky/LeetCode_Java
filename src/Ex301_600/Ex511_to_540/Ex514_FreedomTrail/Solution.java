package Ex301_600.Ex511_to_540.Ex514_FreedomTrail;

import java.util.Arrays;

public class Solution {

    /**
     * 题目需要计算最小的操作数, 使得从ring这个盘中找到key部分
     * 使用Bottom-up的动态规划
     */
    public int findRotateSteps(String ring, String key) {

        int ringLen = ring.length();
        int keyLen = key.length();
        int[] curr = new int[ringLen];
        int[] prev = new int[ringLen];
        Arrays.fill(prev, 0);

        // 最外层遍历key
        for (int keyIdx = keyLen - 1; keyIdx >= 0; keyIdx--) {

            // 内层遍历ring包含的字符, 随后内嵌再次遍历ring的idx, 对ring和key的字符判断,
            // 相同的情况下执行公式: cur[ringIdx] = Math.min(cur[ringIdx], 1 + steps + prev[charIdx])
            Arrays.fill(curr, Integer.MAX_VALUE);
            for (int ringIdx = 0; ringIdx < ringLen; ringIdx++) {
                for (int charIdx = 0; charIdx < ringLen; charIdx++) {
                    if (ring.charAt(charIdx) == key.charAt(keyIdx)) {
                        curr[ringIdx] = Math.min(curr[ringIdx], 1 + countSteps(ringIdx, charIdx, ringLen) + prev[charIdx]);
                    }
                }
            }
            prev = curr.clone();

        }
        return prev[0];
    }

    /**
     * 找到2个在ring字符间的更小的步长(顺时针还是逆时针)
     */
    private int countSteps(int curr, int next, int ringLen) {
        int stepsBetween = Math.abs(curr - next);
        int stepsAround = ringLen - stepsBetween;
        return Math.min(stepsBetween, stepsAround);
    }
}
