package Ex2101_2400.Ex2192_AllAncestorsInDAG;

import java.util.*;

public class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
            indegree[to]++;
        }

        Queue<Integer> nodeWithZeroIndegree = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                nodeWithZeroIndegree.add(i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!nodeWithZeroIndegree.isEmpty()) {
            int currentNode = nodeWithZeroIndegree.poll();
            topologicalOrder.add(currentNode);

            for (int neighbor : adjacencyList[currentNode]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    nodeWithZeroIndegree.add(neighbor);
                }
            }
        }

        List<List<Integer>> ancestorsList = new ArrayList<>();
        List<Set<Integer>> ancestorsSetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestorsList.add(new ArrayList<>());
            ancestorsSetList.add(new HashSet<>());
        }

        for (int node : topologicalOrder) {
            for (Integer neighbor : adjacencyList[node]) {
                ancestorsSetList.get(neighbor).add(node);
                ancestorsSetList.get(neighbor).addAll(ancestorsSetList.get(node));
            }
        }

        for (int i = 0; i < ancestorsList.size(); i++) {
            ancestorsList.get(i).addAll(ancestorsSetList.get(i));
            Collections.sort(ancestorsList.get(i));
        }
        return ancestorsList;
    }
}
