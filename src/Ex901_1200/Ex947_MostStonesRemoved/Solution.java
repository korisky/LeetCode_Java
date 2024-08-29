package Ex901_1200.Ex947_MostStonesRemoved;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(20002);
        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10001);
        }
        return n - uf.componentCount;
    }


    class UnionFind {
        int[] parent;
        int componentCount;
        Set<Integer> uniqueNodes;

        UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            componentCount = 0;
            uniqueNodes = new HashSet<>();
        }

        int find(int node) {
            if (!uniqueNodes.contains(node)) {
                componentCount++;
                uniqueNodes.add(node);
            }
            if (parent[node] == -1) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 == root2) {
                return;
            }
            parent[root1] = root2;
            componentCount--;
        }
    }

}
