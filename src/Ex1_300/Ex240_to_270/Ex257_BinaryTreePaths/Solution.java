package Ex1_300.Ex240_to_270.Ex257_BinaryTreePaths;

import java.util.LinkedList;
import java.util.List;

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        dfs(root, new StringBuilder(), list);
        return list;
    }

    private void dfs(TreeNode curNode, StringBuilder sb, List<String> list) {
        if (curNode != null) {
            int len = sb.length();
            sb.append(curNode.val);
            if (curNode.left == null && curNode.right == null) {
                list.add(sb.toString());
            } else {
                sb.append("->");
                dfs(curNode.left, sb, list);
                dfs(curNode.right, sb, list);
            }
            sb.setLength(len);
        }
    }
}
