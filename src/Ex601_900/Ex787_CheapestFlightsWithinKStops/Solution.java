package Ex601_900.Ex787_CheapestFlightsWithinKStops;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
//        int[] one = new int[]{0, 1, 100};
//        int[] two = new int[]{1, 2, 100};
//        int[] three = new int[]{2, 0, 100};
//        int[] four = new int[]{1, 3, 600};
//        int[] five = new int[]{2, 3, 200};
//        int[][] flights = new int[][]{one, two, three, four, five};
//        System.out.println(findCheapestPrice(4, flights, 0, 3, 1));


        int[] one = new int[]{0, 1, 100};
        int[] two = new int[]{1, 2, 100};
        int[] three = new int[]{0, 2, 500};
        int[][] flights = new int[][]{one, two, three};
        System.out.println(findCheapestPrice(3, flights, 0, 2, 1));
    }


    /**
     * 可以使用经典的 Dijkstra最短距离, 但由于是确认单个最短距离, 所以也可以使用BFS进行尝试
     * e.g. flights = [[0, 1, 100]], 从0到1要100
     */
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 1. 建立Map, <节点i, List<可达节点j, 路程>>
        Map<Integer, List<int[]>> neighbourPathMap = new HashMap<>();
        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            int dis = flight[2];
            List<int[]> neighbourPathList = neighbourPathMap.getOrDefault(start, new LinkedList<>());
            neighbourPathList.add(new int[]{end, dis});
            neighbourPathMap.put(start, neighbourPathList);
        }

        // 2. 初始化minCost, 一共n个节点, 表示从src到每一个节点的距离
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0; // 可0可不0

        // 3. BFS, 不超过k个step的情况下 && queue不为空的情况下,
        int step = 0;
        Queue<int[]> queue = new LinkedList<>(); // 这里queue保存的是 <curNode, curCost>, 当前node
        queue.offer(new int[]{src, 0}); // 从src开始BFS, 每一层可reach的添加到到Queue中

        while (!queue.isEmpty() && step <= k) {
            // BFS经典操作, 此时queue中的size就是这一层可达的部分,
            int curLevelBranch = queue.size();
            while (curLevelBranch-- > 0) {
                // 对每个此时可达的部分进行确认
                int[] cur = queue.poll();
                for (int[] neighbourCost : neighbourPathMap.getOrDefault(cur[0], Collections.emptyList())) {
                    int neighbour = neighbourCost[0];
                    int cost = neighbourCost[1];
                    // 只有明确cost更少的部分进行进一步搜索
                    if (cost + cur[1] < minCost[neighbour]) {
                        minCost[neighbour] = cost + cur[1];
                        queue.offer(new int[]{neighbour, minCost[neighbour]});
                    }
                }
                step++;
            }
        }
        return minCost[dst] < Integer.MAX_VALUE ? minCost[dst] : -1;
    }


}
