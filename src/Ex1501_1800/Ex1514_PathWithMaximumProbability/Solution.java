package Ex1501_1800.Ex1514_PathWithMaximumProbability;

import org.graalvm.collections.Pair;

import java.security.KeyPair;
import java.util.*;

public class Solution {

    /**
     * Bellman-Ford 算法相当于有多少个节点, 就需要重头遍历多少次edges, 一直直到没有node数据更新未知
     */
    public double maxProbability_BellmanFord(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        // 使用一个maxProb记录从start出发到达每一个节点的最大prob
        double[] maxProb = new double[n];
        // 初始化start节点到start自己的prob为1
        maxProb[start_node] = 1.0;

        // 针对node进行遍历
        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;
            // 每一轮都对path进行遍历, 一旦出现当前edge得到的prob>在maxProb初始化的部分
            // 都需要进行更新
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double pathProb = succProb[j];

                // 由于是双向edge, 需要进行2个方向的判断
                // 1) 如果出发点过来prob更大, 那就更新抵达终点的prob
                if (maxProb[u] * pathProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * pathProb;
                    hasUpdate = true;
                }
                // 2) 如果终点过来的prob更大, 那就更新抵达出发点的prob
                if (maxProb[v] * pathProb > maxProb[u]) {
                    maxProb[u] = maxProb[v] * pathProb;
                    hasUpdate = true;
                }
            }
            // Bellman-Ford的快速暂停
            if (!hasUpdate) {
                break;
            }
        }

        // 最后终点的prob就是maxProb中的几率
        return maxProb[end_node];
    }

    /**
     * Dijkstra 算法相当于连通性拓展, 每次从当前已经连接的节点中, 选取最合理的edge添加, 并将其未连接的端点add到visited中
     */
    public double maxProbability_Dijkstra(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double pathProb = succProb[i];
            // 初始化双向edges
            graph.computeIfAbsent(u, k -> new ArrayList<>())
                    .add(Pair.create(v, pathProb));
            graph.computeIfAbsent(v, k -> new ArrayList<>())
                    .add(Pair.create(u, pathProb));
        }

        // 记录maxProb
        double[] maxProb = new double[n];
        maxProb[start_node] = 1d;

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>(
                Comparator.comparingDouble(Pair::getLeft));
        pq.add(Pair.create(1.0, start_node));

        // 遍历直到抵达终点
        while (!pq.isEmpty()) {
            Pair<Double, Integer> bestProbEdge = pq.poll();
            Double curProb = bestProbEdge.getLeft();
            Integer curNode = bestProbEdge.getRight();
            if (curNode == end_node) {
                return curProb;
            }
            // 在当前节点的edges中选择
            for (Pair<Integer, Double> nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
                int nxtNode = nxt.getLeft();
                Double pathProb = nxt.getRight();
                if (curProb * pathProb > maxProb[nxtNode]) {
                    maxProb[nxtNode] = curProb * pathProb;
                    pq.add(Pair.create(maxProb[nxtNode], nxtNode));
                }
            }
        }
        return 0d;
    }


}
