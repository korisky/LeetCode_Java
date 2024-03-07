package Ex1201_1500.Ex1209_RemoveAllAdjacentDuplicates;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        String s = "pbbcggttciidcippooaaisd";
        String s = "abcd";
        System.out.println(sol.removeDuplicates(s, 2));
    }

    /**
     * 使用栈是能看出来的, 重点在于自定义一个Class存储frequency, 可以极大的方便与k进行对比
     */
    public String removeDuplicates(String s, int k) {
        Stack<CharAndFrequency> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().theChar != c) {
                // stack为空 或 stack的peek与当前的char不同, 压入栈
                stack.push(new CharAndFrequency(c, 1));
            } else {
                // 相同则fre添加, 并直接与k对比决定是否出栈
                stack.peek().freq += 1;
                if (stack.peek().freq == k) {
                    stack.pop();
                }
            }
        }
        // 组装string, 需要用到String.valueOf(xxx).repeat方法直接重复, 并且因为Stack的顺序, 每次使用stringBuilder的insert插入0
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            CharAndFrequency theChar = stack.pop();
            sb.insert(0, String.valueOf(theChar.theChar).repeat(theChar.freq));
        }
        return sb.toString();
    }

    public class CharAndFrequency {
        char theChar;
        int freq;

        public CharAndFrequency(char theChar, int freq) {
            this.theChar = theChar;
            this.freq = freq;
        }
    }
}
