package Ex1201_1500.Ex1530_NumberGoodLeafNodesPairs;

import java.util.Objects;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int result = 0;

    /**
     * 题目希望找到所有叶子节点的距离, 如果他们的距离 < distance
     */
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return result;
    }

    /**
     * 核心方法 -> 保留谦虚遍历和后续遍历, 每次针对找到对应subtree
     */
    private int[] dfs(TreeNode root, int distance) {
        if (Objects.isNull(root)) {
            return new int[distance + 1];
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            int[] res = new int[distance + 1];
            res[1]++;
            return res;
        }
        int[] left = dfs(root.left, distance);
        int[] right = dfs(root.right, distance);
        int preSum = 0;
        for (int l = 1; l <= distance; l++) {
            preSum += left[l];
            result += (preSum * right[distance - l]);
        }
        int[] res = new int[distance + 1];
        for (int i = res.length - 2; i >= 1; i--) {
            res[i + 1] = left[i] + right[i];
        }
        return res;
    }


}
