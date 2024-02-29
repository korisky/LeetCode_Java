package Ex1609_EvenOddTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class TreeNode {
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
     * 奇数高度时, 需要确保左边的都比大, 偶数高度时, 需要确保右边的都比左边大
     * 可以想到, 需要一个 flip indicator, 并且使用BFS的方式, 进行比对即可
     */
    public static boolean isEvenOddTree(TreeNode root) {

        if (root == null) {
            return false;
        }

        // 指示物
        // false -> 需要判断从左到右递减,
        // true -> 需要判断从左到右递增
        boolean flipper = true;

        // BFS遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // 确认递减, 或递增
            int lastLeft = !flipper ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            // 这一层总数
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                // 递减
                if (!flipper) {
                    // 并不是递减, 检查错误
                    if (node.val >= lastLeft) {
                        return false;
                    }
                    // 不是even
                    if (node.val % 2 != 0) {
                        return false;
                    }
                }
                // 递增
                if (flipper) {
                    // 并不是递增, 检查错误
                    if (node.val <= lastLeft) {
                        return false;
                    }
                    // 不是odd
                    if (node.val % 2 != 1) {
                        return false;
                    }
                }
                // bfs + 更新数值
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                lastLeft = node.val;
            }
            // flip 调转
            flipper = !flipper;
        }
        return true;
    }

    public static void main(String[] args) {


        TreeNode two = new TreeNode(2);
        TreeNode six = new TreeNode(6);
        TreeNode eight = new TreeNode(8);
        TreeNode tww = new TreeNode(12);
        TreeNode nine = new TreeNode(9, null, two);
        TreeNode seven = new TreeNode(7, six, null);
        TreeNode three = new TreeNode(3, tww, eight);
        TreeNode four = new TreeNode(4, seven, nine);
        TreeNode ten = new TreeNode(10, three, null);
        TreeNode root = new TreeNode(1, ten, four);
        boolean evenOddTree = isEvenOddTree(root);
        System.out.println(evenOddTree);
    }
}
