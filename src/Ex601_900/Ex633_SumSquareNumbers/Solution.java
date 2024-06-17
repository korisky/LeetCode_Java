package Ex601_900.Ex633_SumSquareNumbers;

public class Solution {

    /**
     * 题目需要寻找是否存在 a^2 + b^2 = c 这样的a和b存在
     * 可以通过trick -> 至少其中一个不会超过 根号c
     */
    public static boolean judgeSquareSum(int c) {
        // 这里必须用long类型, 否则会出现计算错误
        long a = 0, b = (long) Math.sqrt(c);
        while (a <= b) {
            long cur = a * a + b * b;
            if (cur == c) {
                return true;
            } else if (cur > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147483600));
    }
}
