package Ex601_900.Ex701_InsertIntoBST;

/**
 * 递归方法过慢, 而且会造成不必要的内存损耗
 */
public class RecursiveSolution {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        if (val < root.val) {
            insertIntoBST(root.left, val);
        } else {
            insertIntoBST(root.right, val);
        }
        return root;
    }
}
