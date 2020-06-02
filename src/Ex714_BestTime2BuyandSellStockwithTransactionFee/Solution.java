package Ex714_BestTime2BuyandSellStockwithTransactionFee;

/*
    The sixth edition is:
        You may complete as many transactions as you like,
        but you need to pay the transaction fee for each transaction.
        You may not buy more than 1 share of a stock at a time
        (ie. you must sell the stock share before you buy again.)
 */

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length < 2)
            return 0;

        int days = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];

        for(int i = 1; i < days; i++){
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i] - fee);
            dp1 = Math.max(dp1, temp - prices[i]);
        }

        return dp0;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
}
