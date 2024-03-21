package Ex1_300.Ex121_to_150.Ex122_BestTime2BuyandSellStockII;

/*
    For the second version, we can do as many transition as we like
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int lastTrans = 0;
        int profitSoFar = 0;
        for (int curPrice : prices) {
            if (curPrice <= buyPrice || curPrice - buyPrice < lastTrans) {
                // 1) If current price is smaller than the price we bought before,
                // that means we should sell it before
                // 2) If current price is less than yesterday's price, we also need to sell it before

                // 1) 意味着, 如果当前价格<=购买价格, 我们应该结算昨天的交易, 所以这里需要将lastTrans加入ProfitSoFar, 重制为今天买入
                // 2) 如果是当前price - 购买时的price, < lastTran所带来的利润, 那么我们也需要昨天就卖出
                buyPrice = curPrice;
                profitSoFar += lastTrans;
                lastTrans = 0;
            } else {
                // here means we gain a higher price, can just keep it to tomorrow
                // 意味着记录如果我们现在卖出, 该交易能为我们带来多少profit, 作为记录, 而不是直接算入profitSoFar
                lastTrans = curPrice - buyPrice;
            }
        }
        // do not forget the last transaction
        profitSoFar += Math.max(0, lastTrans);
        return profitSoFar;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
//        int[] test = new int[]{7,6,4,3,1};
        int[] test = new int[]{7, 1, 2, 5, 3, 6, 4};
        System.out.println(use.maxProfit(test));
    }
}
