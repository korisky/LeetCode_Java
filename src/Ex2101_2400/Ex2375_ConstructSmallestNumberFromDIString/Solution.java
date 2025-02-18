package Ex2101_2400.Ex2375_ConstructSmallestNumberFromDIString;

import java.util.Stack;

public class Solution {

    public static String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        for (int idx = 0; idx <= pattern.length(); idx++) {
            // push next num into the stack
            numStack.push(idx + 1);
            // I is encountered or reach the end, pop all stack ele
            if (idx == pattern.length() || pattern.charAt(idx) == 'I') {
                while (!numStack.isEmpty()) {
                    sb.append(numStack.pop());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(smallestNumber("IIIDIDDD"));
        System.out.println(smallestNumber("DDD"));
    }
}
