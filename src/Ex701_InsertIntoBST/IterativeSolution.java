package Ex701_InsertIntoBST;

/**
 * 递归方法过慢, 而且会造成不必要的内存损耗
 * 使用循环法更直观和迅速
 */
public class IterativeSolution {

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
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                // less than parent
                if (cur.left == null) {
                    // just find the place
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    // still need go through
                    cur = cur.left;
                }
            } else {
                // greater than parent
                if (cur.right == null) {
                    // just find the place
                    cur.right = new TreeNode(val);
                    break;
                } else {
                    // still need go through
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        IterativeSolution solution = new IterativeSolution();
        solution.insertIntoBST(null, 5);
    }
}
