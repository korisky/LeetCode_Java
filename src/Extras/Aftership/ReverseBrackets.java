package Extras.Aftership;

import java.util.Stack;

public class ReverseBrackets {

    /**
     * 题目要求, 对于()的内部需要进行reverse, 需要考虑()嵌套的问题
     * 考虑使用一个Stack处理问题, 不用记录(的位置, 而是直接pop出来得到到(, 然后reverse放回去
     *
     * 题目考核重点是对于stack的运用, 极致的利用stack的push和pop来实现reverse
     */
    public static String reverseStrInBrackets(String inputStr) {

        // 通过stack出入
        Stack<Character> stack = new Stack<>();
        for (char c : inputStr.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                // 如果是), 进行弹出, 弹出直到(
                StringBuilder tmp = new StringBuilder();
                Character cur = stack.pop();
                while (cur != '(') {
                    tmp.append(cur);
                    cur = stack.pop();
                }
                // 到达(后, 又将tmp按照当前顺序push回去
                char[] tmpCharArr = tmp.toString().toCharArray();
                for (int i = 0; i < tmpCharArr.length; i++) {
                    stack.push(tmpCharArr[i]);
                }
            }
        }

        // 弹出stack内容, 最后reverse一下
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStrInBrackets("(())"));
//        System.out.println(reverseStrInBrackets("(bar)"));
//        System.out.println(reverseStrInBrackets("((bar))"));
//        System.out.println(reverseStrInBrackets("abc(def(ghi)k)"));
    }

}
