package Ex91_to_120.Ex99_RecoverBinarySearchTree;

/**
 * 递归方式, 重点在于, 其中找到错误拜访的大的那个元素, 一定是在中序遍历遍历到右子树的时候发现的, 所以赋值是preNode
 * 而找到小的那个元素, 一定是在中序遍历到左子树的时候发现的, 所以赋值是curNode
 */
public class InOrderSolution {

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

    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = null;


    public void recoverTree(TreeNode root) {
        if (null == root)
            return;
        // 1. find two wrong nodes
        traverse(root);
        // 2. swap their val
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void traverse(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        // 1. left traverse
        traverse(curNode.left);
        // 2. do comparing
        if (firstNode == null && (preNode == null || curNode.val <= preNode.val)) {
            // the first wrong node is always larger than any node, and we would run to this only when : go to right branch
            firstNode = preNode;
        }
        if (firstNode != null && curNode.val <= preNode.val) {
            // the second wrong node is always smaller than any node
            secondNode = curNode;
        }
        // keep searching
        preNode = curNode;
        // 3. right traverse
        traverse(curNode.right);
    }
}
