package Ex1_300.Ex91_to_120.Ex103_BinaryTreeZigzagLevelOrderTraversal;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> theQueue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null)
            theQueue.offer(root);

        int zigzag = 1;
        while (!theQueue.isEmpty()) {
            int curLevelNodeNum = theQueue.size();
            List<Integer> curLevelNodes = new ArrayList<>();
            for (int i = 0; i < curLevelNodeNum; i++) {
                TreeNode cur = theQueue.poll();
                if (cur.left != null)
                    theQueue.offer(cur.left);
                if (cur.right != null)
                    theQueue.offer(cur.right);
                if (zigzag > 0)
                    curLevelNodes.add(cur.val);
                else
                    curLevelNodes.add(0, cur.val);
            }
            zigzag *= -1; // reverse the adding direction
            res.add(curLevelNodes);
        }
        return res;
    }
}
