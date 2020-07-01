package Ex783_MinimumDistanceBetweenBSTNodes;

/*
    the minimum difference, would only happen within : left -> parent and parent -> right,
    thus, we can go pre-order (using the iterative version)
 */

import java.util.Stack;

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

    public int minDiffInBST(TreeNode root) {
        int minDis = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null) {
                minDis = Math.min(minDis, root.val - pre.val);
            }
            pre = root;
            root = root.right;
        }
        return minDis;
    }
}
