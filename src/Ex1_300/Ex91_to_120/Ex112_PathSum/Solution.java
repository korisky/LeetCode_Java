package Ex1_300.Ex91_to_120.Ex112_PathSum;

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
     * 递归的方式, 考虑每一次递归都是sum = sum - root.val, 分别向left和right进行搜索
     * 其中当left和right都为null时, 判断当前val = sum, 即能判断出有没有包含这些path
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == sum;
        } else {
            return hasPathSum(root.left, sum - root.val)
                    || hasPathSum(root.right, sum - root.val);
        }
    }
}
