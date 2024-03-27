package Ex1_300.Ex121_to_150.Ex122_BestTime2BuyandSellStockII;


public class AnotherSol {

    /**
     * 极端简单的方式, 直接考虑, 当当前price>上一个price时, 我们累加期间差值, 一定就是我们所获得的
     */
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                // 累加中间的profit, 实际上就是最低买入最高卖出时的价格
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        AnotherSol use = new AnotherSol();
//        int[] test = new int[]{7,6,4,3,1};
        int[] test = new int[]{7, 1, 2, 5, 3, 6, 4};
        System.out.println(use.maxProfit(test));
    }
}
