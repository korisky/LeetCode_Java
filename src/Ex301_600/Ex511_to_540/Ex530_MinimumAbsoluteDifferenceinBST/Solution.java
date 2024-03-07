package Ex301_600.Ex511_to_540.Ex530_MinimumAbsoluteDifferenceinBST;

/*
    the minimum difference, would only happen within : left -> parent and parent -> right,
    thus, we can go pre-order (using the recursion version)
 */

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

    int minDis = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        getMinimumDifference(root.left);
        if (pre != null) {
            if (root.val == pre.val)
                return 0;
            minDis = Math.min(minDis, root.val - pre.val);
        }
        pre = root;
        getMinimumDifference(root.right);
        return minDis;
    }
}
