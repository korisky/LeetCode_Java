package Ex91_to_120.Ex106_ConstructBinaryTreeFromInorderPostorderTraversal;

public class FasterSolution {
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

    int inIdx;
    int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inIdx = inorder.length - 1;
        postIdx = postorder.length - 1;
        return treeConstructor(inorder, postorder, null);
    }

    public TreeNode treeConstructor(int[] inorder, int[] postorder, TreeNode end) {
        if (postIdx < 0)
            return null;

        TreeNode root = new TreeNode(postorder[postIdx--]);

        if (inorder[inIdx] != root.val)
            root.right = treeConstructor(inorder, postorder, root);

        inIdx--;

        if ((end == null) || (inorder[inIdx] != end.val))
            root.left = treeConstructor(inorder, postorder, end);

        return root;
    }
}
