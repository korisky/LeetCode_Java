package Ex601_900.Ex653_TwoSumIV;

import java.util.HashSet;
import java.util.Set;

/**
 * 虽然问题提供了BST的输入, 但实际上使用HashSet的方式更加简便
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

    Set<Integer> met = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (met.contains(root.val)) {
            return true;
        }
        met.add(k - root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
