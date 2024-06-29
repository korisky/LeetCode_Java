package Ex1801_2100.Ex2000_ReversePrefixWord;

import java.util.Stack;

public class Solution {

    /**
     * 使用Stack进行倒置
     */
    public static String reversePrefix(String word, char ch) {


        int idx = 0;
        char[] charArr = word.toCharArray();
        Stack<Character> stack = new Stack<>();

        boolean found = false;
        for (char c : charArr) {
            idx++;
            stack.push(c);
            if (c == ch) {
                found = true;
                break;
            }
        }

        // 不包含字符的特殊情况
        if (!found) {
            return word;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        for (; idx < charArr.length; idx++) {
            sb.append(charArr[idx]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}
