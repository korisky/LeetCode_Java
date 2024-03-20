package Ex301_600.Ex571_to_600.Ex572_SubtreeAnotherTree;

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

    /**
     * 解决方式应该很好想出, check和recursive的顺序要转换一下, 需要将check提前
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (check(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == subRoot;
        }
        return root.val == subRoot.val
                && (check(root.left, subRoot.left) && check(root.right, subRoot.right));
    }

    public static void main(String[] args) {

        TreeNode lestR = new TreeNode(2);
        TreeNode lestL = new TreeNode(1);
        TreeNode lest2R = new TreeNode(5);
        TreeNode lest2L = new TreeNode(4);
        lest2L.left = lestL;
        lest2L.right = lestR;
        TreeNode root = new TreeNode(3);
        root.left = lest2L;
        root.right = lest2R;

        TreeNode subLestR = new TreeNode(2);
        TreeNode subLestL = new TreeNode(1);
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = subLestL;
        subRoot.right = subLestR;


        System.out.println(isSubtree(root, subRoot));
    }
}
