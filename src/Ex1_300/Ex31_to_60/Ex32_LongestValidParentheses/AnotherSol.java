package Ex1_300.Ex31_to_60.Ex32_LongestValidParentheses;

import java.util.Stack;

public class AnotherSol {


    /**
     * Stack的版本, 空间复杂度为 O(n)
     */
    public int longestValidParentheses_Stack(String s) {

        if (null == s || s.length() < 2) {
            return 0;
        }

        // 这里push -1的意思是, 如果只剩下一个了, 那么也能得到大小
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLen = Integer.MIN_VALUE;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                // 保存当前index
                stack.push(i);
            } else {
                // 先pop出来一个
                stack.pop();
                if (!stack.isEmpty()) {
                    // 如果当前栈不为空, 那么path就是跟peek进行对比
                    maxLen = Math.max(maxLen, i - stack.peek());
                } else {
                    // 如果当前就是空, 那么也是进行push, 这个位置作为下一个valid的开始
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }


    /**
     * 解题核心在于, 使用栈是最早的推导方法, 但由于只有left和right两种指标, 所以可以用left和right来进行记录
     * 需要从左到右, 从右到左进行记录, 以从左到右为例
     * 1) 如果当前left == right, 可以考虑都是valid的, maxLen = 2 x right's number
     * 2) 如果当前right > left, 那么需要重置left & right为0
     * 3) 从右到左也要做一遍遍历
     */
    public int longestValidParentheses(String s) {

        if (null == s || s.length() < 2) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int maxLen = 0;

        // 从左到右
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            // 判断当前符号
            if (charArr[i] == '(') {
                left++;
            } else {
                right++;
            }
            // 确认当前情况
            if (left == right) {
                // left与right相同数量, 证明是valid的
                maxLen = Math.max(maxLen, 2 * right);
            } else if (left < right) {
                // left < right 证明当前是invalid的, 需要重置
                left = 0;
                right = 0;
            }
        }

        // 从右到左
        left = 0;
        right = 0;
        for (int i = charArr.length - 1; i >= 0; i--) {
            // 判断当前符号
            if (charArr[i] == '(') {
                left++;
            } else {
                right++;
            }
            // 确认当前情况
            if (left == right) {
                // left与right相同数量, 证明是valid的
                maxLen = Math.max(maxLen, 2 * left);
            } else if (right < left) {
                // right < left, 证明当前是invalid的, 需要重置
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        AnotherSol use = new AnotherSol();
        String test = "()()(()()))";
        System.out.println(use.longestValidParentheses(test));
    }
}
