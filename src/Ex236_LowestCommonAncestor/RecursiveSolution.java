package Ex236_LowestCommonAncestor;

/**
 * 需要找到给出的两个节点的最近父节点,
 * 这里可能有两种情况:
 * 1. 如果两个是兄弟节点, 那么它们祖先的某个父节点就是这个LCA,
 * 2. 如果某个节点是某个节点的祖先, 那么这个祖先就是LCA
 */
public class RecursiveSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // here root == p & root == q, means we can go backward.
        // if p & q is in same sub tree, then first reach node would be the lca
        // if p & q is not in same sub tree, we still need to reach them and go backwards
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if one of the sub tree is not null, means we might find the p or q node, need to return it
        if (left == null || right == null) {
            return left != null ? left : right;
        }

        // or else, we just return the root node
        return root;
    }
}
