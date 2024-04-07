package Ex601_900.Ex678_ValidParenthesisString;

import java.util.Stack;

public class Solution {

    /**
     * Ex1249的本体版, 可以同样使用类似的方法保存valid和invalid的index到stack中
     * 但由于存在 * 可以作为左右或者empty, 可以尝试使用2个stack, 一个保存OpenBracket的index, 一个保存*的index
     */
    public static boolean checkValidString(String s) {


        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        char[] charArr = s.toCharArray();

        // 遍历进行push
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '*') {
                starStack.push(i);
            } else if (charArr[i] == '(') {
                openStack.push(i);
            } else if (charArr[i] == ')') {
                // 右括号时需要进行额外判断, 是可以跟(匹配还是需要用上*
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    // 当左(没有并且*也没有, 一定为invalid
                    return false;
                }
            }
        }

        // 最后判断left(和*的位置是否合理, (必须要在*的左边才行
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            Integer leftIdx = openStack.pop();
            Integer starIdx = starStack.pop();
            if (leftIdx > starIdx) {
                return false;
            }
        }

        return openStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString(")("));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("((*)"));
    }
}
