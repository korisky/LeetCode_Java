package Ex901_1200.Ex1038_BSTGreaterSumTree;

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

    int pre = 0;

    /**
     * 题目目标是, 生成一个新的tree, 其中每个node的val都变为自己+树中所有比自己大的节点
     * 实际上因为是BST, 直接使用右节点优先的中国序续遍历, 即可
     */
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) {
            bstToGst(root.right);
        }
        pre = root.val = pre + root.val;
        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }


}
