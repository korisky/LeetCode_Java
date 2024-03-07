package Ex901_1200.Ex948_BagTokens;

import java.util.Arrays;

/**
 * 题目大致核心, power相当于初始资金, 每次参与token[i]需要花费1积分, 或者花费1积分获取这么多的token[i], 目标是最大化积分
 * 这里的核心是greedy strategy, 尽可能在低token位置花费获得积分, 高token位置花费积分
 * 另外, 问题里面并没有说, 你一定要从0号token池, 玩到1号token池这样, 所以对于贪心算法来说, 就是直接sort整个token池, 是可行的
 */
public class Solution {

    public static void main(String[] args) {
        int[] tokens = new int[]{200, 150};
        System.out.println(bagOfTokensScore(tokens, 150));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {

        // 题目没有限制一定要按照顺序进行, 所以使用贪心算法的基本面, 首先进行排序
        Arrays.sort(tokens);

        // curPoints代表还剩多少积分, 我们力求获取最大积分maxPoints
        int maxPoints = 0, curPoints = 0,
                i = 0, j = tokens.length - 1;

        // 左右双向逼近
        while (i <= j) {

            if (power >= tokens[i]) {
                // power作为手上剩余的token, 判断是否可以花钱买到积分, 贪心算法, 要在低位买更多, 所以一定都买入
                power -= tokens[i++];
                // 记录当前持有的
                maxPoints = Math.max(maxPoints, ++curPoints);

            } else if (curPoints > 0) {
                // 无法花费token买入时, 考虑花费积分获得最多的token
                curPoints--;
                power += tokens[j--];

            } else {
                // 结束
                break;
            }
        }

        return maxPoints;
    }
}
