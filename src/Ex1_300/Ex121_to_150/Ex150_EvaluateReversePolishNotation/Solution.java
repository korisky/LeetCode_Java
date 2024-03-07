package Ex1_300.Ex121_to_150.Ex150_EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            int v1;
            int v2;

            if (token.equals("+")) {
                v2 = stack.pop();
                v1 = stack.pop();
                stack.push(v1 + v2);
            } else if (token.equals("-")) {
                v2 = stack.pop();
                v1 = stack.pop();
                stack.push(v1 - v2);
            } else if (token.equals("*")) {
                v2 = stack.pop();
                v1 = stack.pop();
                stack.push(v1 * v2);
            } else if (token.equals("/")) {
                v2 = stack.pop();
                v1 = stack.pop();
                stack.push(v1 / v2);
            } else {
                int operand = Integer.parseInt(token);
                stack.push(operand);
            }
        }
        return stack.pop();
    }
}
