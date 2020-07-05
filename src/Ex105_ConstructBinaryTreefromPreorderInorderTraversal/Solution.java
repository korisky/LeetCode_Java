package Ex105_ConstructBinaryTreefromPreorderInorderTraversal;

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
     * Main Problem here is : we need to construct with root.right, and it's starting index is // line 42
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeConstructor(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode treeConstructor(int preIdx, int inStaIdx, int inEndIdx, int[] preorder, int[] inorder) {
        if (preIdx > preorder.length - 1 || inStaIdx > inEndIdx)
            return null;
        TreeNode root = new TreeNode(preorder[preIdx]);
        int inIdxOfRoot = inStaIdx;
        for (int i = inStaIdx; i <= inEndIdx; i++) {
            if (inorder[i] == root.val) {
                inIdxOfRoot = i;
                break;
            }
        }
        int rightChildIdx = preIdx + 1 + (inIdxOfRoot - inStaIdx); // preOrder + 1 (to next) + (inIdxOfRoot - inStaIdx) (num of left nodes)
        root.left = treeConstructor(preIdx + 1, inStaIdx, inIdxOfRoot - 1, preorder, inorder);
        root.right = treeConstructor(rightChildIdx, inIdxOfRoot + 1, inEndIdx, preorder, inorder);
        return root;
    }
}
