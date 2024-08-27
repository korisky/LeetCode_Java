package Ex1501_1800.Ex1514_PathWithMaximumProbability;

public class Solution {


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


}
