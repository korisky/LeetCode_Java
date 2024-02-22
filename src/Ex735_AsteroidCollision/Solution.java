package Ex735_AsteroidCollision;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
//        int[] test = new int[]{-2, -1, 1, 2};
        int[] test = new int[]{2, -2};
//        int[] test = new int[]{1, -2, -2, -2};
//        int[] test = new int[]{2, -1, 1, -2};
        int[] ints = asteroidCollision(test);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 绝对值代表小行星的质量, 碰撞之后小质量的会会消失, 负数代表向左, 正数代表向右, 同向小行星不会发生碰撞
     */
    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty() || stack.peek() * asteroid > 0) {
                stack.push(asteroid);
            } else {
                // 如果stack往左, 目前往右, 也不需要考虑相撞
                if (stack.peek() < 0) {
                    stack.push(asteroid);
                    continue;
                }
                // 明确相撞, 对stack内容进行遍历
                boolean astWin = false;
                while (!stack.isEmpty()) {
                    // 方向相同, 不用再撞
                    if (stack.peek() * asteroid > 0) {
                        stack.push(asteroid);
                        astWin = false;
                        break;
                    }
                    // 质量相同, 抵消, 不用再撞
                    if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                        stack.pop();
                        astWin = false;
                        break;
                    }
                    // 方向不同, 确认质量大小
                    if (Math.abs(stack.peek()) > Math.abs(asteroid)) {
                        // stack下的质量更大, 不用再撞
                        astWin = false;
                        break;

                    } else {
                        // stack下的质量小, 当前asteroid赢了, 继续尝试撞
                        stack.pop();
                        astWin = true;
                    }
                }
                // 如果小行星把已有的stack撞没了, 它要进入stack
                if (stack.isEmpty() && astWin) {
                    stack.push(asteroid);
                }
            }
        }

        List<Integer> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        int idx = 0;
        int[] result = new int[list.size()];
        for (Integer i : list.reversed()) {
            result[idx++] = i;
        }

        return result;
    }
}
