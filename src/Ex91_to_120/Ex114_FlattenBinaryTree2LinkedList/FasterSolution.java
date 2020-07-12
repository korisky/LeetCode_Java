package Ex91_to_120.Ex114_FlattenBinaryTree2LinkedList;

public class FasterSolution {

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

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root != null) {
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }
    }

    public static void main(String[] args) {
        FasterSolution use = new FasterSolution();
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        TreeNode r2 = new TreeNode(4);
        l1.right = r2;
        TreeNode l2 = new TreeNode(5);
        r1.left = l2;
        use.flatten(root);
        System.out.println("finished");
    }
}
