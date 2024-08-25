package Ex1_300.Ex121_to_150.Ex145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    The idea is about, after we traversed the node, and add it's left and right nodes, we should set them to null
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

    /**
     * Non-recursive solution -> using Stack
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root.right != null || root.left != null) {
                if (root.right != null) {
                    stack.push(root.right);
                    root.right = null;
                }
                if (root.left != null) {
                    stack.push(root.left);
                    root.left = null;
                }
            } else {
                res.add(root.val);
                stack.pop();
            }
        }
        return res;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postTraverseHelper(root, result);
        return result;
    }

    private void postTraverseHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postTraverseHelper(root.left, list);
        postTraverseHelper(root.right, list);
        list.add(root.val);
    }


}
