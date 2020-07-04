package Ex110_BalancedBinaryTree;

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
     The method is about using a bottom up method
     to build the tree from the leaf, then we can directly
     compare the height
     */

    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(right - left) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
