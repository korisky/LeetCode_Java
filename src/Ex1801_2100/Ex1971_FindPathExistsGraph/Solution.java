package Ex1801_2100.Ex1971_FindPathExistsGraph;

import java.util.*;

public class Solution {

    /**
     * 普通的DFS方式, 由于是无向图, 可以对visited进行持续记录
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // 1) 将edges进行加载
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            // 双向进行打通
            graph.computeIfAbsent(a, val -> new ArrayList<>())
                    .add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<>())
                    .add(a);
        }

        // 2) 使用遍历而不是递归来进行search
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            // 找到的情况
            Integer curNode = stack.pop();
            if (curNode == destination) return true;
            // 找不到的情况, 将它neighbor添加到stack
            for (Integer neighbor : graph.get(curNode)) {
                // 尽针对没有visit过的node
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }
}
