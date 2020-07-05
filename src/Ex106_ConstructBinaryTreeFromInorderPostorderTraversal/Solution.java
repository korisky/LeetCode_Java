package Ex106_ConstructBinaryTreeFromInorderPostorderTraversal;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return treeConstructor(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    public TreeNode treeConstructor(int postIdx, int inStaIdx, int inEndIdx, int[] inorder, int[] postorder) {
        if (postIdx < 0 || inStaIdx > inEndIdx)
            return null;

        TreeNode root = new TreeNode(postorder[postIdx]);
        int inIdxOfRoot = 0;
        for (int idx = inStaIdx; idx <= inEndIdx; idx++) {
            if (inorder[idx] == root.val) {
                inIdxOfRoot = idx;
                break;
            }
        }
        int rightChildNum = inEndIdx - inIdxOfRoot;
        root.right = treeConstructor(postIdx - 1, inIdxOfRoot + 1, inEndIdx, inorder, postorder);
        root.left = treeConstructor(postIdx - rightChildNum - 1, inStaIdx, inIdxOfRoot - 1, inorder, postorder);
        return root;
    }
}
