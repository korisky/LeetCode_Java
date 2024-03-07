package Ex1_300.Ex211_to_240.Ex224_BasicCalculator;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String txt = "(14+(4+5+2)-3)+(6+18)";
        System.out.println(calculate(txt));
    }

    /**
     * 题目要求作出一个+-的计算器, 核心在于从左到右遍历我们需要考虑, 遇到(时要将当前tmpResult存到stack中
     * 每次)之后由从Stack中pop出来, 与当前手上的numResult进行叠加
     */
    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;


        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
                continue;
            }

            if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
                continue;
            }

            if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
                continue;
            }

            // 在遇到括号才使用Stack
            if (c == '(') {
                // 先暂存结果
                stack.push(result);
                // 再存上一个的sign
                stack.push(sign);
                // 重新将sign和当前结果重置
                result = 0;
                sign = 1;
                continue;
            }

            if (c == ')') {
                // 遇到)证明结束该运算符
                result += sign * num;
                num = 0;
                // 对符号回乘
                result *= stack.pop();
                // 重新计算结果
                result += stack.pop();
                continue;
            }
        }

        // 最后为number
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }
}
