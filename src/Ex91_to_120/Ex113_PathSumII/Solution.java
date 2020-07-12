package Ex91_to_120.Ex113_PathSumII;

import java.util.ArrayList;
import java.util.List;

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

    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        helper(root, sum, new ArrayList<>());
        return res;
    }

    public void helper(TreeNode root, int sum, ArrayList<Integer> tempList) {
        if (root != null) {
            tempList.add(root.val);
            int remain = sum - root.val;
            if (remain == 0 && root.left == null && root.right == null) {
                res.add(new ArrayList<>(tempList));
            } else {
                helper(root.left, sum - root.val, tempList);
                helper(root.right, sum - root.val, tempList);
            }
            tempList.remove(tempList.size() - 1);
        }
    }
}
