package Ex301_600.Ex301_to_330.Ex309_BestTime2BuyandSellStockwithCooldown;

/*
    The changes on fifth edition:
        1) You may not engage in multiple transactions at the same time
            (ie, you must sell the stock before you buy again).
        2) After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */

/*
    Idea from Youtube: use hold and no-stock to represent money on hand with stock holding and
    money on hand without stock holding, respectively
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int[] withStock = new int[prices.length + 1];
        int[] withoutStock = new int[prices.length + 1];
        withStock[0] = 0;
        withStock[1] = -prices[0];
        withoutStock[0] = withoutStock[1] = 0;
        for (int d = 1; d < prices.length; d++){
            withStock[d + 1] = Math.max(withStock[d], withoutStock[d - 1] - prices[d]);
            withoutStock[d + 1] = Math.max(withoutStock[d], withStock[d] + prices[d]);
        }
        return withoutStock[withoutStock.length - 1];
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.maxProfit(new int[]{1,2,3,0,2}));
    }
}
