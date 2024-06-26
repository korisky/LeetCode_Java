package Ex1201_1500.Ex1382_BalanceBinarySearchTree;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * 题目希望对一个连续的tree进行重新平衡, 核心trick在于,
     * 使用中序遍历之后, 我们就知道root是在中间是Balance的,
     * 那么就以中间为出发点, 找到它的左右子树进行build即可
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        internalTraverse(root, inOrder);
        return constructBSTFromIntervalOrder(inOrder, 0, inOrder.size() - 1);
    }

    private void internalTraverse(TreeNode root, List<Integer> inOrder) {
        if (Objects.isNull(root)) {
            return;
        }
        internalTraverse(root.left, inOrder);
        inOrder.add(root.val);
        internalTraverse(root.right, inOrder);
    }

    private TreeNode constructBSTFromIntervalOrder(List<Integer> inOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        // mid 就是当前子树的root
        int mid = (start + end) / 2;
        TreeNode left = constructBSTFromIntervalOrder(inOrder, start, mid - 1);
        TreeNode right = constructBSTFromIntervalOrder(inOrder, mid + 1, end);
        // 构建
        TreeNode treeNode = new TreeNode(inOrder.get(mid));
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }

}
