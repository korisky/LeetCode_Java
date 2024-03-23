package Ex1_300.Ex151_to_180.Ex151_ReverseWordsString;

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

    public String reverseWordsCorrect(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!strs[i].isEmpty()) {
                sb.append(strs[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String sen = "a good   example";
        String s1 = s.reverseWordsCorrect(sen);
        System.out.println(s1);
    }
}
