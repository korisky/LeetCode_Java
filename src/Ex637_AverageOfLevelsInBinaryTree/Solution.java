package Ex637_AverageOfLevelsInBinaryTree;

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

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> theQueue = new LinkedList<>();
        List<Double> res = new ArrayList<>();

        if (root != null)
            theQueue.offer(root);

        while (!theQueue.isEmpty()) {
            int curLevelNodeNum = theQueue.size();
            Double curSum = 0.0d;
            for (int i = 0; i < curLevelNodeNum; i++) {
                TreeNode cur = theQueue.poll();
                if (cur.left != null)
                    theQueue.offer(cur.left);
                if (cur.right != null)
                    theQueue.offer(cur.right);
                curSum += cur.val;
            }
            res.add(curSum / curLevelNodeNum);
        }
        return res;
    }
}
