package Ex309_BestTime2BuyandSellStockwithCooldown;

public class FasterSolution {
    public int maxProfit(int[] prices) {
        int sold = 0;
        int held = Integer.MIN_VALUE;
        int rest = 0;

        for(int price: prices) {
            int temp = sold;
            sold = held + price;
            held = Math.max(held, rest - price);
            rest = Math.max(rest, temp);
        }
        return Math.max(sold, rest);
    }
}
