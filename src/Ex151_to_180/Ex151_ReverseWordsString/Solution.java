package Ex151_to_180.Ex151_ReverseWordsString;

import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        String[] strs = s.trim().split(" ");
        for (String str : strs) {
            stack.push(str);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String sen = "  hello world  ";
        String s1 = s.reverseWords(sen);
        System.out.println(s1);
    }
}
