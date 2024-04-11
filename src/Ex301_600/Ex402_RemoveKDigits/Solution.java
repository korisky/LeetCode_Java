package Ex301_600.Ex402_RemoveKDigits;

import java.util.Stack;

public class Solution {

    /**
     * 题目给定提出k个数字, 使得string能够最小, 核心是一个greedy算法:
     * 1) 从左到右遍历(最高位开始), 遍历时判断,
     * 2) 如果当前stack不为空, 且上一个digit比当前的大, 并且我们的k还没用完, 那么我们就pop出来, 否则push进去
     * 3) 如果我们k还没用完, 那么我们就pop出来stack的最后一位, 这样组成的数字也是更小
     * 4) 随后需要从栈底开始遍历组成数字（因为从左到右可能组成的数字以0开头）
     */
    public static String removeKdigits(String num, int k) {

        // 进行遍历压栈, 每次压栈需要判断栈顶元素是否比当前元素大, 是的话需要pop出来
        // stack相当于记录我们要留下来的数字, 而每次pop出来数字时, 对应k也要变化, k已经没有了我们也不能再pop
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 如果k没用完, 类似情况对应数字 '12345', 那么我们从栈顶(数字尾部)进行出栈, 也就是可以组成的最小数字了
        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        // 这里的遍历, 是从stack的栈底开始遍历 (所以这个地方没有严格的使用栈, 而是从前往后, 因为要判断)
        for (Character c : stack) {
            if (leadingZero && c == '0') continue;
            leadingZero = false;
            sb.append(c);
        }

        // 返回判断
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }
}
