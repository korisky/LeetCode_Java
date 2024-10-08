package Ex1801_2100.Ex1963_MinimumNumSwapsMakeStringBalanced;

import java.util.Stack;

public class Solution {

    /**
     * 问题核心在于, 每一次swap实际上处理了2个unbalance的括号,
     * 那么我们只需要记录unbalance的括号有多少个, 最后swap次数一定是其/2, 使用一个stack来进行存储
     */
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int unbalanced = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                // handler [, just push
                stack.push(c);
            } else {
                // handler ], pop [ or add unbalanced
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    unbalanced++;
                }
            }
        }
        return (unbalanced + 1) / 2;
    }
}
