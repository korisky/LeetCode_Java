package Ex91_to_120.Ex102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> theQueue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null)
            theQueue.offer(root);

        while (!theQueue.isEmpty()) {
            int curLevelNodeNum = theQueue.size();
            List<Integer> curLevelNodes = new ArrayList<>();
            for (int i = 0; i < curLevelNodeNum; i++) {
                TreeNode cur = theQueue.poll();
                if (cur.left != null)
                    theQueue.offer(cur.left);
                if (cur.right != null)
                    theQueue.offer(cur.right);
                curLevelNodes.add(cur.val);
            }
            res.add(curLevelNodes);
        }
        return res;
    }
}
