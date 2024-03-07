package Ex1201_1500.Ex1249_MinimumRemoveValidParentheses;

import java.util.HashSet;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
//        String text = "lee(t(c)o)de)";
        String text = "a)b(c)d";
//        String text = "))((";
        System.out.println(minRemoveToMakeValid(text));
    }


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
