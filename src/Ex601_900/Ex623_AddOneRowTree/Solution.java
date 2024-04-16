package Ex601_900.Ex623_AddOneRowTree;

import java.util.LinkedList;
import java.util.Queue;

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
     * 可以考虑BFS的方式, 进行添加
     */
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (root == null) return null;

        TreeNode dumHead = new TreeNode(0);
        dumHead.left = root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(dumHead);

        int height = 0;
        while (height++ < depth) {
            if (height == depth) {
                // 遇到位置
                while (!queue.isEmpty()) {
                    addInternalLayer(queue.poll(), val);
                }
                break;

            } else {
                // 还没遇到, 正常BFS
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
        }

        return dumHead.left;
    }


    private static void addInternalLayer(TreeNode root, int val) {
        TreeNode left = root.left;
        root.left = new TreeNode(val);
        root.left.left = left;
        TreeNode right = root.right;
        root.right = new TreeNode(val);
        root.right.right = right;
    }

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        two.left = four;
        TreeNode one = new TreeNode(1);
        one.left = two;
        one.right = three;

        addOneRow(one, 5, 1);
    }
}
