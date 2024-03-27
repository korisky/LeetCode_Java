package Ex1_300.Ex181_to_210.Ex188_BestTime2BuyandSellStockIV;

import Ex1_300.Ex121_to_150.Ex122_BestTime2BuyandSellStockII.Solution;

import java.util.Arrays;

public class FasterSolution {
    public static int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length < 2)
            return 0;
        if (k > prices.length / 2)
            return helper(prices); // if k > prices.length, means we can do transaction as many as we can

        /**
         * 如果k非常有限, 则使用dp的方式, 同时维护k+1长度的profits数组和balance数组
         */
        int[] balance = new int[k + 1];
        int[] profits = new int[k + 1];
        // 将balance填入最小值
        Arrays.fill(balance, Integer.MIN_VALUE);

        // 对price进行遍历, 并同时对k进行遍历
        for (int price : prices) { // using days as outer loop, but the formula is the same
            for (int i = 1; i <= k; i++) {
                // 这里的profit可以理解为, 第i次交易, 要么是当前Profit, 要么是Balance[i] + 当前price
                profits[i] = Math.max(profits[i], balance[i] + price);
                // 这里的balance则可以理解为, 要么是当前balance不变, 要么是上一个profit-当前price, 意味着我们得到了更多的balance (balance + price = profit)
                balance[i] = Math.max(balance[i], profits[i - 1] - price);
            }
        }
        return profits[k];
    }

    /**
     * 如果k>prices的长度的一半, 退化为122中的解决方式
     */
    public static int helper(int[] prices) {
        int buyPrice = prices[0];
        int singleTrans = 0;
        int profitSoFar = 0;
        for (int curPrice : prices) {
            if (curPrice <= buyPrice || curPrice - buyPrice < singleTrans) {
                buyPrice = curPrice;
                profitSoFar += singleTrans;
                singleTrans = 0;
            } else {
                singleTrans = curPrice - buyPrice;
            }
        }
        return profitSoFar + Math.max(0, singleTrans);
    }

    public static void main(String[] args) {
        int[] test = new int[]{7, 1, 2, 5, 3, 6, 4};
        System.out.println(maxProfit(2, test));
    }
}
