package Ex181_to_210.Ex199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

/**
 * 思想在于, 由于每一层只会选择其中一个node, 我们可以右序遍历,
 * 然后记录depth, 一旦到达一个更深的depth, 不管是left branch 还是 right branch,
 * 这个方法都是选出了需要的值
 */
public class DfsSolution {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        dfs(root, results, 0);
        return results;
    }

    public void dfs(TreeNode root, List<Integer> results, int curDepth) {
        if (root == null) {
            return;
        }
        // most imp. line, each depth we only choose one node
        // we might encounter that, left branch might deeper than right branch
        if (curDepth == results.size()) {
            results.add(root.val);
        }
        // go right first, then go left
        dfs(root.right, results, curDepth + 1);
        dfs(root.left, results, curDepth + 1);
    }

}
