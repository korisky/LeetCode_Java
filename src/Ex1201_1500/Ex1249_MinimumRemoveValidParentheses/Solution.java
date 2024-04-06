package Ex1201_1500.Ex1249_MinimumRemoveValidParentheses;

import java.util.HashSet;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String text = "lee(t(c)o)de)";
//        String text = "a)b(c)d";
//        String text = "))((";
        System.out.println(minRemoveToMakeValid(text));
    }


    /**
     * 题目需要构造一个最小修改得来的validString, 使得左右括号位置合理
     * 核心是使用Stack进行存储, 每次遇到(进行index的存储, 遇到)则尝试pop出来,
     * 如果pop出来的是)那么这两个都不用存到stack, 不合理的index都会存到stack,
     * 最后重新遍历string, 遇到这些还在stack中的肯定就不是合理的
     */
    public static String minRemoveToMakeValid(String s) {

        Stack<Integer> charIdxStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                // do nothing

            } else if (c == '(') {
                charIdxStack.push(i);

            } else if (c == ')') {
                if (!charIdxStack.isEmpty() && s.charAt(charIdxStack.peek()) == '(') {
                    charIdxStack.pop();
                } else {
                    charIdxStack.push(i);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(charIdxStack);
        for (int i = 0; i < s.length(); i++)
            if (!set.contains(i)) {
                result.append(s.charAt(i));
            }
        return result.toString();
    }
}
