package Ex124_BinaryTreeMaximumPathSum;

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


    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPath;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = Math.max(helper(root.left), 0); // here must need to compare 0, because might have negative node
        int rightMax = Math.max(helper(root.right), 0);

        maxPath = Math.max(maxPath, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}
