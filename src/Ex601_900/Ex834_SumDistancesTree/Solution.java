package Ex601_900.Ex834_SumDistancesTree;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {


    int[] res, count;
    ArrayList<HashSet<Integer>> tree;


    /**
     * 题目需要找到从每个节点到另外所有节点的路径总和
     * 1) 可以考虑从每个节点开始出发, 进行BFS确认位置是否有节点, 有节点+高度
     * -> 当前我们只有edge, 对每个节点都进行树的重构繁杂
     * -> 可见的有不少重复计算的部分
     * <p>
     * 2) lee215给出的idea -> 遍历时, 实际上都是距离某个node近了又距离某些node远了
     */
    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        // init
        tree = new ArrayList<>();
        res = new int[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }

        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        // 调用2种深度遍历
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    private void dfs(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }

    private void dfs2(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
    }
}
