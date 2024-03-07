package Ex1_300.Ex91_to_120.Ex111_MinimumDepthOfBinaryTree;

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

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 1;
        Queue<TreeNode> theQueue = new LinkedList<>();
        theQueue.offer(root);

        while (!theQueue.isEmpty()) {
            int curLevelNodeNum = theQueue.size();
            for (int i = 0; i < curLevelNodeNum; i++) {
                TreeNode cur = theQueue.poll();
                if (cur.left == null && cur.right == null)
                    return depth;
                if (cur.left != null)
                    theQueue.offer(cur.left);
                if (cur.right != null)
                    theQueue.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
