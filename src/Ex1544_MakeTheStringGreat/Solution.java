package Ex1544_MakeTheStringGreat;

public class Solution {


    /**
     * 题目需要剔除所有的连续字母, 刚好同一个字符连续但前后是大小写的情况,
     * 这里可以很快想到ASCII码的A比a小32个字符数目的情况, 通过绝对值与32进行对比,
     * 一旦发现, 需要剔除这2个字符, 也可以通过substring将前面和后面2个字符串进行拼接, 进行递归调用
     */
    public static String makeGood(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                return makeGood(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println('a' - 'A');
    }
}
