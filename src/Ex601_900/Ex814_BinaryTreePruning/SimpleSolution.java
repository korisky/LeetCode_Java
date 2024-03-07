package Ex601_900.Ex814_BinaryTreePruning;

/**
 * 去除所有子树不包含任何1的子树
 * 需要去除的叶节点属于: 值是0, 左子树为空, 右子树也为空, 这个时候就需要将这个节点去除, 也就是set null
 * 只需要递归返回即可
 */
public class SimpleSolution {

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

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return (root.val == 1 || root.left != null || root.right != null) ? root : null;
    }
}
