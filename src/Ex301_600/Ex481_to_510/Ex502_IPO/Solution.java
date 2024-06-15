package Ex301_600.Ex481_to_510.Ex502_IPO;

/*
    The question can be seen as :
        we need to find the maximum profit project, within our current capital

    We can use two priority queue to do this:
        the first one store the project by their capital, we keep polling until our current capital
        is not enough for that project.
        the second one store project by their profit, we can only addi the project we can
        start by now: which means the one just polling from the first priority queue.
 */

import java.util.PriorityQueue;

public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

        // 包裹2个类型的PriorityQueue, 分别更高的profit和更低的capital排序
        PriorityQueue<int[]> byCapital = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> byProfit = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        // 首先存入Capital队列, 越低越好
        for (int i = 0; i < Profits.length; i++) {
            byCapital.offer(new int[]{Capital[i], Profits[i]});
        }

        // 然后开始进行项目选择
        for (int project_k = 0; project_k < k; project_k++) {

            // 从Capital最小的开始选, 并且需要确认, 我们当前的资金W是>=这个最小capital的
            // 这里的W还是不变的, 相当于找到所有当前W能选的project
            while (!byCapital.isEmpty() && W >= byCapital.peek()[0]) {
                // 放入到byProfit中, 不动获取的W资金
                byProfit.offer(byCapital.poll());
            }

            // 没钱再进行project了, 判断是不是一个project都不能做了
            if (byProfit.isEmpty()) {
                break;
            }

            // 如果还有, 那么选取最大profit的一个进行执行
            W += byProfit.poll()[1];
        }

        return W;
    }
}
