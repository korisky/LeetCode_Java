package Ex901_1200.Ex993_CousinsInBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

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

    public boolean isCousins(TreeNode root, int x, int y) {
        if (x == y)
            return false;

        Queue<TreeNode> theQueue = new LinkedList<>();
        boolean findX = false;
        boolean findY = false;

        if (root != null)
            theQueue.offer(root);

        while (!theQueue.isEmpty()) {
            int curLevelNodeNum = theQueue.size();
            for (int i = 0; i < curLevelNodeNum; i++) {
                TreeNode cur = theQueue.poll();
                if (cur != null) {
                    TreeNode left = cur.left;
                    TreeNode right = cur.right;
                    if (left != null && right != null) {
                        if ((left.val == x || left.val == y) && (right.val == x || right.val == y))
                            return false;
                        else if (left.val == x || right.val == x)
                            findX = true;
                        else if (left.val == y || right.val == y)
                            findY = true;
                    } else if (left != null) {
                        if (left.val == x)
                            findX = true;
                        if (left.val == y)
                            findY = true;
                    } else if (right != null) {
                        if (right.val == x)
                            findX = true;
                        if (right.val == y)
                            findY = true;
                    }
                    theQueue.offer(left);
                    theQueue.offer(right);
                }
            }
            if (findX && findY)
                return true;
            else if (findX != findY)
                break;
        }
        return false;
    }
}
