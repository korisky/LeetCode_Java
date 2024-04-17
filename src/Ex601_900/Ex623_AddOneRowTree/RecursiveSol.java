package Ex601_900.Ex623_AddOneRowTree;


/**
 * 方法类似, 但使用递归的方式会更加的迅速, 这里相当于使用了dfs
 */
public class RecursiveSol {
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

    private TreeNode dfs(TreeNode root, int val, int depth, int curDepth) {

        // 当遇到depth为1, 特殊处理, 在头部进行添加
        if (depth == 1) {
            TreeNode interval = new TreeNode(val);
            interval.left = root;
            return interval;
        }

        // 正常bfs
        if (root == null) {
            return root;
        }

        // 触碰到depth, 进行新增
        if (curDepth == depth - 1) {
            TreeNode leftRemain = root.left;
            TreeNode rightRemain = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = leftRemain;
            root.right.right = rightRemain;
            return root;
        }

        // 进行广度遍历
        dfs(root.left, val, depth, curDepth + 1);
        dfs(root.right, val, depth, curDepth + 1);
        return root;
    }


    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return dfs(root, val, depth, 1);
    }
}
