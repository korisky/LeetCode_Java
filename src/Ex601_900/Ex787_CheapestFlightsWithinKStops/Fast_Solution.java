package Ex601_900.Ex787_CheapestFlightsWithinKStops;

import java.util.Arrays;

public class Fast_Solution {

    /**
     * 前面Solution是找到src节点到每一个节点的距离, 实际上当flights这个二维数组内容不多时, 直接全部遍历也是可行的
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        // 这是另一种全量的BFS
        for (int i = 0; i <= k; i++) {
            if (isRoutePossible(minCost, flights)) {
                break;
            }
        }
        return minCost[dst] < Integer.MAX_VALUE ? minCost[dst] : -1;
    }

    /**
     * 相较于去找Map里面某个节点的可达, 这里直接复制minCost作为上一趟结果, 然后当前再全量遍历
     * 当发现有一个Node的minCost被修改过, 但是却发现当前遍历结果比上一个高, 知道该层已经遍历完毕, 返回false跳出
     */
    private boolean isRoutePossible(int[] minCost, int[][] flights) {

        int[] copy = Arrays.copyOf(minCost, minCost.length);
        boolean result = true;

        for (int[] flight : flights) {
            int curSrc = flight[0];
            int curDst = flight[1];
            int cost = flight[2];

            // 当第一次进入时, 只有minCost[src]是0, 所以只有它会触发, 然后更新minCost[src的邻居们]
            if (copy[curSrc] < Integer.MAX_VALUE
                    && minCost[curDst] > minCost[curSrc] + cost) {
                minCost[curDst] = cost + copy[curSrc];
                result = false;
            }
        }

        return result;
    }
}
