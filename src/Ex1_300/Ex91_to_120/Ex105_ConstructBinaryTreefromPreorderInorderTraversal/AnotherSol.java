package Ex1_300.Ex91_to_120.Ex105_ConstructBinaryTreefromPreorderInorderTraversal;

public class AnotherSol {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    public TreeNode treeConstructor(int preIdx, int inStaIdx, int inEndIdx, int[] preorder, int[] inorder) {
        // 1. 越界返回
        if (preIdx > preorder.length - 1 || inStaIdx > inEndIdx) {
            return null;
        }
        // 2. 当前preIdx就是该子树的root, 从中序遍历中找到该节点位置。中序遍历中该节点左边就是左子树, 右边就是右子树, 进行递归构建
        TreeNode curRoot = new TreeNode(preorder[preIdx]);
        // 找到中序遍历中该root的idx
        int inIdx = 0;
        for (int i = inStaIdx; i < inorder.length; i++) {
            if (inorder[i] == curRoot.val) {
                inIdx = i;
                break;
            }
        }
        // 递归构建左子树与右子树
        // 左子树构建较好理解, 由于前序遍历每一个节点都是当前子树的root,  所以这里直接+1, staIdx也不变, 但endIdx则一定在当前inIdx-1的位置
        curRoot.left = treeConstructor(preIdx + 1, inStaIdx, inIdx - 1, preorder, inorder);
        // 右子树较为复杂, 主要在于preIdx位置, 是当前preIdx的位置 + 左子树的节点数量 (inIdx - inStaIdx + 1), 而右子树的start当然就是当前inIdx+1的位置
        curRoot.right = treeConstructor(preIdx + inIdx - inStaIdx + 1, inIdx + 1, inEndIdx, preorder, inorder);
        return curRoot;
    }
}
