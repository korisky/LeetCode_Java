package Ex1_300.Ex121_to_150.Ex124_BinaryTreeMaximumPathSum;

/**
 * 实现方式实际需要想到是后续遍历, 从最小的叶子节点开始往上聚合存在的maxPath,
 * 单个叶子节点的时候, 我们就需要判断它是否<0, <0的叶子节点全部抛弃,
 * 而总的path有>0的可以考虑
 */
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


    public static int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPath;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = Math.max(helper(root.left), 0); // here must need to compare 0, because might have negative node
        int rightMax = Math.max(helper(root.right), 0);

        maxPath = Math.max(maxPath, root.val + leftMax + rightMax);

        // 这里是从题目定义而来, 一条路径一定是从root开始, 然后延展过去不断, 所以对于val来说, 返回的内容一定是2个节点,
        // 所以对于当前节点来说, 返回值只能是自己val + left或right的最大值
        return root.val + Math.max(leftMax, rightMax);
        // Definition of a Path: In the context of this problem, a valid path must be continuous and unidirectional,
        // meaning you can't go down one branch of the tree and then back up to traverse down another branch.
        // Therefore, at any given node, the maximum sum path that continues through that node to its parent can either
        // come from its left child or its right child, not both.
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(20);
        n3.left = n1;
        n3.right = n2;
        TreeNode n4 = new TreeNode(9);
        TreeNode root = new TreeNode(-10);
        root.left = n4;
        root.right = n3;

        Solution use = new Solution();
        System.out.println(use.maxPathSum(root));
    }
}
