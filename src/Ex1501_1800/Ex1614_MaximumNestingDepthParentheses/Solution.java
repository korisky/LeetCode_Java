package Ex1501_1800.Ex1614_MaximumNestingDepthParentheses;

import java.util.Stack;

public class Solution {

    /**
     * 题目复杂, 但是实际上只需要使用stack进行处理
     */
    public static int maxDepth(String s) {
        int ans = 0;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                st.pop();
            }
            ans = Math.max(ans, st.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
