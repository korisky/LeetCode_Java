package Ex121_to_150.Ex123_BestTime2BuyandSellStockIII;

/*
    The third version of this question is about, we can only do TWICE transition,
    also we must sell the stock before we buy again.

    Idea from Youtube:
        e.g. [3,3,5,0,0,3,1,4], calculating two transition that means we can separate it
        into two sequences and then add their maximum profit together. But we need to
        traverse all possible combination of separating on WHICH index.

        [3] [3, 5, 0, 0, 3, 1, 4]
        [3, 4] [5, 0, 0, 3, 1, 4]
        [3, 4, 5] [0, 0, 3, 1, 4]
        ....
        [3, 4, 5, 0, 0, 3, 1] [4]

        Their is a pattern over above sequences:
        1) for the first sequence, it must start on index 0
        2) for the second sequence, it must end on index (size - 1)

        Then, we can calculating first sequence's and second sequence's maximum Profit on EACH LENGTH, respectively
        S1: [0, 0, 2, 2, 2, 3, 3, 4] (left 2 right)
            (we need to store a Current Lowest Price we meet, and updating Maximum Profit with traversing)
        S2: [4, 4, 4, 4, 4, 3, 3, 0] (right 2 left)
            (we need to store a Current Highest Price we meet, and updating Maximum Profit with traversing)

        Then adding them together, would be the result on separating on each Index.
        [4, 4, 6, 6, 6, 6, 6, 3]
 */

public class SolutionBySeparatingSequence {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1)
            return 0;

        int[] profitOnIndex = new int[prices.length];
        int curLowest = Integer.MAX_VALUE;
        int curMaxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < curLowest)
                curLowest = prices[i];
            else
                curMaxProfit = Math.max(curMaxProfit, prices[i] - curLowest);
            profitOnIndex[i] = curMaxProfit;
        }

        int curHighest = 0;
        curMaxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > curHighest)
                curHighest = prices[i];
            else
                curMaxProfit = Math.max(curMaxProfit, curHighest - prices[i]);
            profitOnIndex[i] += curMaxProfit;
        }

        int MaximumProfit = 0;
        for (int profit : profitOnIndex) {
            if (profit > MaximumProfit)
                MaximumProfit = profit;
        }

        return MaximumProfit;
    }

    public static void main(String[] args) {
        SolutionBySeparatingSequence use = new SolutionBySeparatingSequence();
        int[] test = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(use.maxProfit(test));
    }
}
