package Ex1_300.Ex270_to_300.Ex297_SerializeDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目核心是希望可以序列化TreeNode为一条String, 并能支持反序列化
 * 重点: 序列化时使用简单BFS即可, 这样反序列化时可以很简单的从左到右遍历
 * 反序列化时, 核心在于也放入一个queue, 这样连续的判断某个node的 i+1 和 i+2是否为null, 否则将这个parent的left和right都设置回去
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            if (root == null) {
                return "";
            }

            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    // empty
                    sb.append("n ");
                } else {
                    // not empty
                    sb.append(node.val + " ");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if (data == "") {
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            queue.add(root);

            for (int i = 1; i < values.length; i++) {
                TreeNode parent = queue.poll();
                if (!values[i].equals("n")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    queue.add(left);
                }
                if (!values[++i].equals("n")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    queue.add(right);
                }
            }
            return root;
        }
    }
}
