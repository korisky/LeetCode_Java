package Ex1_300.Ex31_to_60.Ex32_LongestValidParentheses;

/*
This idea is about: we go through the string from left 2 right and right 2 left
1. from left 2 right, we assume that: once right's number is greater than left's it's invalid
2. from right 2 left, we assume that: once left's number is greater than right's it's invalid
 */

public class longestValidParentheses_S_WithoutStack {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxLength = Math.max(maxLength, 2 * right);
            else if (right >= left)
                left = right = 0;
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxLength = Math.max(maxLength, 2 * left);
            else if (left >= right)
                left = right = 0;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        longestValidParentheses_S_WithoutStack use = new longestValidParentheses_S_WithoutStack();
        String test = "()()(()()))";
        System.out.println(use.longestValidParentheses(test));
    }
}
