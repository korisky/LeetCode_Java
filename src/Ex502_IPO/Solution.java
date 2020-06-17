package Ex502_IPO;

/*
    The question can be seen as :
        we need to find the maximum profit project, within our current capital

    We can use two priority queue to do this:
        the first one store the project by their capital, we keep polling until our current capital
        is not enough for that project.
        the second one store project by their profit, we only adding the project we can
        start by now: which means the one just polling from the first priority queue.
 */

import java.util.PriorityQueue;

public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

//        PriorityQueue<int[]> byCapital = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
//        PriorityQueue<int[]> byProfit = new PriorityQueue<>(Comparator.comparingInt(x -> -x[1]));

        PriorityQueue<int[]> byCapital = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> byProfit = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < Profits.length; i++)
            byCapital.offer(new int[]{Capital[i], Profits[i]});

        for (int project_k = 0; project_k < k; project_k++) {

            while (!byCapital.isEmpty() && W >= byCapital.peek()[0])
                byProfit.offer(byCapital.poll());

            if (byProfit.isEmpty())
                break;

            W += byProfit.poll()[1];
        }

        return W;
    }
}
