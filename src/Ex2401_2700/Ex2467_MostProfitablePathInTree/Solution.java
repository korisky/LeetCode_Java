package Ex2401_2700.Ex2467_MostProfitablePathInTree;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        ArrayList<Integer>[] graph = new ArrayList[amount.length];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] bobPath = new int[amount.length];
        Arrays.fill(bobPath, -1);
        ArrayList<Integer> path = new ArrayList<>();
        fillBobPath(bob, -1, path, graph);

        for (int i = 0; i < path.size(); i++) {
            bobPath[path.get(i)] = i;
        }
        return getAliceMaxScore(0, -1, 0, bobPath, graph, 0, amount);
    }

    private boolean fillBobPath(int node, int parentNode, ArrayList<Integer> path, ArrayList<Integer>[] graph) {
        if (node == 0) {
            return true;
        }
        for (Integer neighborNode : graph[node]) {
            if (!neighborNode.equals(parentNode)) {
                // add into path
                path.add(node);
                // recursion
                if (fillBobPath(neighborNode, node, path, graph)) {
                    return true;
                }
                // remove checked path
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    private int getAliceMaxScore(int node, int parentNode, int curScore, int[] bobPath, ArrayList<Integer>[] graph,
                                 int timestamp, int[] amount) {

        if (bobPath[node] == -1 || bobPath[node] > timestamp) {
            // alice take all score
            curScore += amount[node];
        } else if (bobPath[node] == timestamp) {
            // alice share score with bob
            curScore += amount[node] / 2;
        }

        if (graph[node].size() == 1 && node != 0) {
            return curScore;
        }

        int maxScore = Integer.MIN_VALUE;
        for (Integer neighborNode : graph[node]) {
            if (!neighborNode.equals(parentNode)) {
                maxScore = Math.max(maxScore,
                        getAliceMaxScore(neighborNode, node, curScore, bobPath, graph, timestamp + 1, amount));
            }
        }
        return maxScore;
    }
}
