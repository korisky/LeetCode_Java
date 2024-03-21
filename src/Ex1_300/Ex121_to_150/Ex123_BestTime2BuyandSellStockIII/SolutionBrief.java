package Ex1_300.Ex121_to_150.Ex123_BestTime2BuyandSellStockIII;

/*
    The idea is from LeetCode:
        1) Considering we have NO MONEY at first, and we need to buy the stock by BORROWING money.

        2) Then, we need to find a day to MAXIMISE the profit and finished our first selling.

        3) After that, we need to buy stock again, we want to MAXIMISE the money that we're holing on our hand,
        That would be (Profit after first selling - curring stock's price). Which can also consider as:
        we use some money to EXCHANGE some stocks.

        4) Finally, the money on our hand would be (Money we left after Exchanged by some stocks
        + current these stocks' price)
 */

public class SolutionBrief {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int buy1 = Integer.MAX_VALUE; // Special initialization here, assuming we broke .....
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int curPrice : prices) {
            buy1 = Math.min(buy1, curPrice);
            sell1 = Math.max(sell1, curPrice - buy1);
            buy2 = Math.min(buy2, curPrice - sell1);
            sell2 = Math.max(sell2, curPrice - buy2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        SolutionBrief use = new SolutionBrief();
        int[] test = new int[]{7, 6, 4, 3, 1};
        System.out.println(use.maxProfit(test));
    }
}
