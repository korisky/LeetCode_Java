package Ex601_900.Ex797_AllPathsFromSource2Target;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] row1 = {1, 2};
        int[] row2 = {3};
        int[] row3 = {3};
        int[] row4 = {};
        int[][] graph = new int[][]{row1, row2, row3, row4};
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        for (List<Integer> list : lists) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }

    /**
     * 题目需要找到所有, 从0节点到n-1节点的路径, 可以DFS + visitedNodeMap
     * 输入graph[][] -> [[1,2]] 是指0可以到1, 或者2节点
     */
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resultList = new LinkedList<>();
        dfsVisited(graph, 0, new LinkedList<>(), new HashSet<>(), resultList);
        return resultList;
    }


    public static void dfsVisited(int[][] graph, int curIdx, List<Integer> curPath, Set<Integer> visited, List<List<Integer>> results) {

        // 添加当前节点到路径
        curPath.add(curIdx);

        if (curIdx == graph.length - 1) {
            // 到达目标节点, 记录内容
            results.add(new ArrayList<>(curPath));
        } else {
            // 未到达目标节点, 持续DFS可行的路径
            int[] paths = graph[curIdx];
            for (int path : paths) {
                // 避免环 (但是DAG图的意思是不会存在环)
                if (visited.contains(path)) {
                    continue;
                }
                // 递归
                visited.add(path);
                dfsVisited(graph, path, curPath, visited, results);
                visited.remove(path);
            }
        }

        // 剔除当前节点为路径
        curPath.removeLast();
    }
}
