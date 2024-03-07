package Ex1_300.Ex91_to_120.Ex114_FlattenBinaryTree2LinkedList;

import java.util.Stack;

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

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root.left == null && root.right == null) { // means we need to pop stuff from stack
                if (stack.isEmpty())
                    break;
                root.right = stack.pop();
            } else {
                if (root.left != null) {
                    if (root.right != null)
                        stack.push(root.right);
                    root.right = root.left;
                    root.left = null;
                }
            }
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        TreeNode r2 = new TreeNode(4);
        l1.right = r2;
        TreeNode l2 = new TreeNode(5);
        r1.left = l2;
        use.flatten(root);
        System.out.println("finished");
    }
}
