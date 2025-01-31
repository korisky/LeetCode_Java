package Ex601_900.Ex827_MakingALargeIsland;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    class DisjointSet {

        public int[] parent;
        public int[] islandSize;

        public DisjointSet(int n) {
            parent = new int[n];
            islandSize = new int[n];
            for (int node = 0; node < n; node++) {
                parent[node] = node;
                islandSize[node] = 1;
            }
        }

        public int findRoot(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findRoot(parent[node]);
        }

        public void unionNodes(int nodeA, int nodeB) {
            int rootA = findRoot(nodeA);
            int rootB = findRoot(nodeB);

            // already in same set
            if (rootA == rootB) {
                return;
            }

            if (islandSize[rootA] < islandSize[rootB]) {
                parent[rootA] = rootB;
                islandSize[rootB] += islandSize[rootA];
            } else {
                parent[rootB] = rootA;
                islandSize[rootA] += islandSize[rootB];
            }
        }
    }


    /**
     * Disjoint Set Union, 首先将当前已经存在的island的点进行统计划分, 再尝试connect找到使其最大化的配置
     */
    public int largestIsland(int[][] grid) {

        // step 1: init & unit set
        int rows = grid.length;
        int columns = grid[0].length;

        DisjointSet ds = new DisjointSet(rows * columns);

        int[] rowDirections = {1, -1, 0, 0};
        int[] columnDirections = {0, 0, 1, -1};

        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {

                if (grid[currentRow][currentColumn] == 1) {
                    // flatten
                    int currentNode = (columns * currentRow) + currentColumn;

                    for (int direction = 0; direction < 4; direction++) {
                        int neighborRow = currentRow + rowDirections[direction];
                        int neighborColumn = currentColumn + columnDirections[direction];

                        if (neighborRow >= 0 && neighborRow < rows && neighborColumn >= 0 && neighborColumn < columns
                                && grid[neighborRow][neighborColumn] == 1) {
                            int neighborNode = columns * neighborRow + neighborColumn;
                            ds.unionNodes(currentNode, neighborNode);
                        }
                    }
                }
            }
        }

        // step 2: calculate maximum possible island size
        int maxIslandSize = 0;
        boolean hasZero = false;
        Set<Integer> uniqueRoots = new HashSet<>();

        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                if (grid[currentRow][currentColumn] == 0) {
                    hasZero = true;
                    int currentIslandSize = 1;
                    // extend
                    for (int direction = 0; direction < 4; direction++) {
                        int neighborRow = currentRow + rowDirections[direction];
                        int neighborColumn = currentColumn + columnDirections[direction];
                        if (neighborRow >= 0 && neighborRow < rows && neighborColumn >= 0 && neighborColumn < columns
                                && grid[neighborRow][neighborColumn] == 1) {
                            int neighborNode = columns * neighborRow + neighborColumn;
                            int root = ds.findRoot(neighborNode);
                            uniqueRoots.add(root);
                        }
                    }

                    // sum up size
                    for (Integer root : uniqueRoots) {
                        currentIslandSize += ds.islandSize[root];
                    }

                    // clear
                    uniqueRoots.clear();

                    // update
                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }
        }

        return !hasZero ? rows * columns : maxIslandSize;
    }
}
