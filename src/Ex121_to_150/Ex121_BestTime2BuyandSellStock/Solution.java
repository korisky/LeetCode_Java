package Ex121_to_150.Ex121_BestTime2BuyandSellStock;


/*
    The problem is relaxed to: you can only buy and sell once,
    the profit was calculated by: price_current - price_before, do not need to consider time.

    We only need to constrain: higher price make sense only when it's later than current's price
 */


public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i : prices) {
            if (i <= minPrice)
                minPrice = i;
            else
                maxProfit = Math.max(maxProfit, i - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(use.maxProfit(new int[]{7,6,5,4,3,2,1}));
    }
}
