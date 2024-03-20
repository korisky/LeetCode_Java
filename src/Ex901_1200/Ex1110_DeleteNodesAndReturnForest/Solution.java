package Ex901_1200.Ex1110_DeleteNodesAndReturnForest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    List<TreeNode> remaining = new LinkedList<>();
    Set<Integer> toDelete = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) {
            toDelete.add(i);
        }
        dfsDel(root, true);
        return remaining;
    }

    public TreeNode dfsDel(TreeNode root, boolean isRoot) {

        if (root == null) {
            return null;
        }

        boolean needsDel = toDelete.contains(root.val);
        // 核心难点在这, isRoot是上一个node传递过来的, 如果上一个需要被delete,
        // 而当前这个节点不需要被delete, 则肯定是remain, 就可以添加
        if (isRoot && !needsDel) {
            remaining.add(root);
        }

        // 而递归调用时, 如果当前被delete了, 那么就会告知下一个节点, 需要变为root
        // 并且这里需要进行更新, 截断null的部分
        root.left = dfsDel(root.left, needsDel);
        root.right = dfsDel(root.right, needsDel);
        return needsDel ? null : root;
    }


}
