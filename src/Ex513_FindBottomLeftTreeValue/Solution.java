package Ex513_FindBottomLeftTreeValue;

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

    public class TreeNodeWithHeight {
        TreeNode node;

        int height;

        public TreeNodeWithHeight(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    int lastBottomHeight = Integer.MIN_VALUE;
    int lastBottomVal = 0;

    public void findBottomLeftValWithHeight(TreeNodeWithHeight treeNodeWithHeight) {

        TreeNode node = treeNodeWithHeight.node;
        int height = treeNodeWithHeight.height;

        // 如果左侧不为空, 深度遍历左侧子树
        if (node.left != null) {
            findBottomLeftValWithHeight(new TreeNodeWithHeight(node.left, height + 1));

        } else if (height > lastBottomHeight) {
            // 如果左侧为空, 左侧深度遍历截止, 尝试对比
            lastBottomHeight = height;
            lastBottomVal = node.val;
        }

        // 如果右侧不为空, 走一趟右侧, 然后再继续深度遍历左侧
        if (node.right != null) {
            findBottomLeftValWithHeight(new TreeNodeWithHeight(node.right, height + 1));
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValWithHeight(new TreeNodeWithHeight(root, 0));
        return lastBottomVal;
    }


}
