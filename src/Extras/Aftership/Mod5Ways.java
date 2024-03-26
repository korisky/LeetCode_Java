package Extras.Aftership;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mod5Ways {


    /**
     * 题目: 给出一个数字字符串, 其中?代表可以填入0-9, 给出所有的可能, 使得数字 n % 13 == 5 成立
     * 这是一题动态规划, 其中?可能存在多个
     */
    public static int mod13Remains5(String str) {

        /*
            虽然%操作是针对整个数, 但从左到右遍历时, 可以发现每在末尾添加一个数, 实际上是当前数 x10 + 末尾数字,
            并且由于取模操作, 实际上我们可以把当前数, 直接替换为 (余数 x 10 + 末尾数字) % 13,
            并且由于我们是进行方案数目的筛选, 这里考虑的是对于不同余数, 我们都进行遍历, 所以遍历的方式是 -> (每一种余数 + digit) % 13 然后添加结果
         */

        // r -> 字符串位置, c -> 当前余数
        char[] charArr = str.toCharArray();
        int[][] dp = new int[charArr.length + 1][13];

        // 初始化, 当没有数字时, 取模为0的方案为1
        dp[0][0] = 1;
        for (int r = 1; r <= charArr.length; r++) {
            char curDigit = charArr[r - 1];
            for (int c = 0; c < 13; c++) {
                if (curDigit != '?') {
                    // 如果不是?, 直接计算当前digit取模情况
                    int remain = (10 * c + Character.getNumericValue(curDigit)) % 13;
                    // 这里的意思是, 当前取模得到的方法, 要加上上一个取模得到的值, 这里是需要考虑remain得到的余数的来源way, 一定要加上上一个remain的ways
                    dp[r][remain] += dp[r - 1][c];
                } else {
                    // 2) 如果是?, 计算0-9所有情况
                    for (int i = 0; i <= 9; i++) {
                        int remain = (10 * c + i) % 13;
                        // 同样需要考虑, 这里的来源ways
                        dp[r][remain] += dp[r - 1][c];
                    }
                }
            }
        }
        // 求的是5的remain
        return dp[charArr.length][5];
    }

    public static void main(String[] args) {
        System.out.println(mod13Remains5("??5"));

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <= 9; i++) {
            char first = (char) ('0' + i);
            for (int j = 0; j <= 9; j++) {
                char second = (char) ('0' + j);
                StringBuilder sb = new StringBuilder();
                sb.append(first).append(second).append("5");
                int num = Integer.parseInt(sb.toString());
                if (num % 13 == 5) {
                    list.add(num);
                }
            }
        }
        System.out.println();

        System.out.println("Nums size: " + list.size());
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
