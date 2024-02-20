package Ex181_to_210.Ex188_BestTime2BuyandSellStockIV;

/*
    The third version of this question is about, we can only do k-times transition,
    also we must sell the stock before we buy again.
 */

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length < 2)
            return 0;
        if (k > prices.length / 2)
            return helper(prices); // if k > prices.length, means we can do transaction as many as we can

        int[] lastProfit = new int[prices.length];
        int[] curProfit = new int[prices.length];

        for (int i = 1; i <= k; i++) {
            int maxRemaining = -prices[0]; // the first day we 'borrow' money to buy stock
            for (int d = 1; d < prices.length; d++) {
                curProfit[d] = Math.max(curProfit[d - 1], prices[d] + maxRemaining);
                // left: no transaction today   right: current max remaining money + the money I sold stock today
                maxRemaining = Math.max(maxRemaining, lastProfit[d] - prices[d]);
                // means: I sold stock today, let me check the maximum amount of money I can have,
                // is just like yesterday (maxRemaining, left), or I didn't do transaction in current loop but by
                // stock in today (lastProfit[d] - prices[d], right).
            }
            lastProfit = curProfit;
            curProfit = new int[prices.length];
        }

        return lastProfit[prices.length - 1];
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

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test =  new int[]{3,2,6,5,0,3};
        System.out.println(use.maxProfit(2, test));
    }
}
