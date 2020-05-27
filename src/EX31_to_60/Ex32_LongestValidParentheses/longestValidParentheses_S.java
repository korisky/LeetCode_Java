package EX31_to_60.Ex32_LongestValidParentheses;

import java.util.Stack;

/*
The main idea from LeetCode's method:
    The longest valid parentheses MUST between 2 invalid parentheses
 */


public class longestValidParentheses_S {
    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();

        // 1. get all invalid parentheses' indexes
        Stack<Integer> invalIndex = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                invalIndex.push(i);
            else if (!invalIndex.isEmpty() && s.charAt(invalIndex.peek()) == '(')
                invalIndex.pop();
            else
                invalIndex.push(i);
        }

        // 2. figure out the longest valid parentheses
        if (invalIndex.isEmpty())
            return s.length();
        int maxLength = 0;
        int rightBar = s.length() - 1;
        while (!invalIndex.isEmpty()) {
            // check each valid parentheses between dif invalid 'bar'
            int curBar = invalIndex.pop();
            maxLength = Math.max(maxLength, rightBar - curBar);
            rightBar = curBar - 1;
        }
        // here is about, the valid sequence between start of the array and 'first' invalid parentheses
        maxLength = Math.max(maxLength, rightBar + 1);
        return maxLength;
    }

    public static void main(String[] args) {
        longestValidParentheses_S use = new longestValidParentheses_S();
        String test = "()()(()()))";
        System.out.println(use.longestValidParentheses(test));
    }
}
