package Ex1_300.Ex121_to_150.Ex129_SumRoot2LeafNumbers;

public class AnotherSol {
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


    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    /**
     * dfs, 但应该类似后序遍历, 左右子树都是null的情况下才累计
     */
    private void dfs(TreeNode root, Integer prev) {

        if (root == null) {
            return;
        }

        int curNum = 10 * prev + root.val;
        dfs(root.left, curNum);
        dfs(root.right, curNum);

        // 左右子树都是null, 确认为叶子结点, 可以进行记录
        if (root.left == null && root.right == null) {
            sum += curNum;
        }
    }

}
