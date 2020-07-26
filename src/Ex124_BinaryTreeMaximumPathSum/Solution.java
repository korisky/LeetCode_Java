package Ex124_BinaryTreeMaximumPathSum;

public class Solution {
    public static class TreeNode {
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


    public static int maxPath = Integer.MIN_VALUE;

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
        // another tricky part, if we still go up from this node (include the current parent node and its ancestors)
        // we can only choose left or right path + current val, but not left + right
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(20);
        n3.left = n1;
        n3.right = n2;
        TreeNode n4 = new TreeNode(9);
        TreeNode root = new TreeNode(-10);
        root.left = n4;
        root.right = n3;

        Solution use = new Solution();
        System.out.println(use.maxPathSum(root));
    }
}
