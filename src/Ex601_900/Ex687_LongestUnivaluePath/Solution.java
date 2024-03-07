package Ex601_900.Ex687_LongestUnivaluePath;

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

    private static int MaxLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return MaxLen;
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        MaxLen = Math.max(MaxLen, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
