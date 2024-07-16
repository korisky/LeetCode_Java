package Ex1801_2100.Ex2096_StepDirectionsBinaryTreeNodeAnother;

import java.util.Objects;

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

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3, null, null);
        TreeNode one = new TreeNode(1, three, null);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode two = new TreeNode(2, six, four);
        TreeNode root = new TreeNode(5, one, two);

        System.out.println(getDirections(root, 3, 6));
    }

    /**
     * 题目希望找到两个BST节点的最短路径, 实际上与Ex236找到LCA最近父节点是类似的
     * 先找到抵达的路径, 随后再将出发点到LCA之间的路径全部替换为U即可
     */
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        // 找到路径
        findDfs(root, startValue, startPath);
        findDfs(root, destValue, destPath);
        // 需要注意reverse
        startPath.reverse();
        destPath.reverse();
        // 剔除从root走到LCA的部分
        while (!startPath.isEmpty() && !destPath.isEmpty()
                && startPath.charAt(0) == destPath.charAt(0)) {
            startPath.deleteCharAt(0);
            destPath.deleteCharAt(0);
        }
        return "U".repeat(startPath.length()) + destPath;
    }

    /**
     * 负责找到节点
     */
    public static boolean findDfs(TreeNode root, int targetVal, StringBuilder pathStr) {
        if (root.val == targetVal) {
            return true;
        }
        if (!Objects.isNull(root.left) && findDfs(root.left, targetVal, pathStr)) {
            pathStr.append("L");
            return true;
        }
        if (!Objects.isNull(root.right) && findDfs(root.right, targetVal, pathStr)) {
            pathStr.append("R");
            return true;
        }
        return false;
    }
}
