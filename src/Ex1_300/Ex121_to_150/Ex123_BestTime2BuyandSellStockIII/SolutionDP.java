package Ex1_300.Ex121_to_150.Ex123_BestTime2BuyandSellStockIII;

public class SolutionDP {

    /**
     * 使用Dynamic Programming, 但实际上是一种双向的搜索
     * 一个array负责从左到右, 一个array负责从右到左, 记录当前能获得的maxProfit
     * 最后结合两个array, 两个累加的max, 就是2次交易可以得到的max
     */
    public int maxProfit(int[] prices) {

        if (null == prices) {
            return 0;
        }

        int n = prices.length;

        // 为了方便, 让r2l进行+1
        int leftMin = prices[0]; // 记住初始化
        int rightMax = prices[n - 1]; // 记住初始化
        int[] l2rProfit = new int[n];
        int[] r2lProfit = new int[n + 1]; // 方便处理

        // 单次遍历填补值
        for (int i = 1; i < n; i++) {
            // left, 从左向右更新最小买入price
            l2rProfit[i] = Math.max(l2rProfit[i - 1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);

            // right, 从右向左更新最大卖出price
            int j = n - 1 - i;
            r2lProfit[j] = Math.max(r2lProfit[j + 1], rightMax - prices[j]);
            rightMax = Math.max(rightMax, prices[j]);
        }

        // 找到left和right最大的profit组合
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, l2rProfit[i] + r2lProfit[i + 1]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        SolutionDP use = new SolutionDP();
//        int[] test = new int[]{7, 6, 4, 3, 1};
        int[] test = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(use.maxProfit(test));
    }
}
