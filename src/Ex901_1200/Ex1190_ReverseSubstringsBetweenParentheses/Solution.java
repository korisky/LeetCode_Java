package Ex901_1200.Ex1190_ReverseSubstringsBetweenParentheses;

import java.util.*;

public class Solution {

    /**
     * 考虑直接使用Deque进行输入输出, 不考虑重复操作
     */
    public static String reverseParentheses(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (')' != c) {
                deque.addLast(c);
            }
            if (')' == c) {
                Queue<Character> tmpQueue = new LinkedList<>();
                while (deque.getLast() != '(') {
                    Character popChar = deque.removeLast();
                    tmpQueue.offer(popChar);
                }
                // pop '('
                deque.removeLast();
                while (!tmpQueue.isEmpty()) {
                    deque.addLast(tmpQueue.poll());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : deque) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
}
