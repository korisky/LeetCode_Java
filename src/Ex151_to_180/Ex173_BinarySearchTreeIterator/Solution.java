package Ex151_to_180.Ex173_BinarySearchTreeIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
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

    class BSTIterator {
        int curIdx = 0;
        List<TreeNode> list;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root);
                root = root.right;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.get(curIdx++).val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return curIdx < list.size();
        }
    }
}
