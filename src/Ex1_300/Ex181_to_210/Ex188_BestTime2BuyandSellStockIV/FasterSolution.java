package Ex1_300.Ex181_to_210.Ex188_BestTime2BuyandSellStockIV;

import java.util.Arrays;

public class FasterSolution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length < 2)
            return 0;
        if (k > prices.length / 2)
            return helper(prices); // if k > prices.length, means we can do transaction as many as we can

        int[] balance = new int[k + 1];
        int[] profits = new int[k + 1];
        Arrays.fill(balance, Integer.MIN_VALUE);

        for (int price : prices) { // using days as outer loop, but the formula is the same
            for (int i = 1; i <= k; i++) {
                profits[i] = Math.max(profits[i], balance[i] + price);
                balance[i] = Math.max(balance[i], profits[i - 1] - price);
            }
        }
        return profits[k];
    }

    public int helper(int[] prices) {
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
        profitSoFar += Math.max(0, singleTrans);
        return profitSoFar;
    }
}
