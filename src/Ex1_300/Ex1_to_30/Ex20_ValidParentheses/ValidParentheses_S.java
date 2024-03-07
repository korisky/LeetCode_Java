package Ex1_300.Ex1_to_30.Ex20_ValidParentheses;

//Example 1:
//
//        Input: "()"
//        Output: true
//Example 2:
//
//        Input: "()[]{}"
//        Output: true
//Example 3:
//
//        Input: "(]"
//        Output: false

import java.util.Stack;

public class ValidParentheses_S {

    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curBra = s.charAt(i);
            if (curBra == '(' || curBra == '{' || curBra == '[')
                brackets.add(curBra);
            else {
                if (brackets.isEmpty())
                    return false;
                char topBra = brackets.pop();
                if ((topBra == '(' && curBra == ')') || (topBra == '{' && curBra == '}')
                        || (topBra == '[' && curBra == ']'))
                    continue;
                else
                    return false;
            }
        }
        if (brackets.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses_S use = new ValidParentheses_S();
        System.out.println(use.isValid("]{}"));
    }
}
