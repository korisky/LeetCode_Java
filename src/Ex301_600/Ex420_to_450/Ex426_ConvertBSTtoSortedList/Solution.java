package Ex301_600.Ex420_to_450.Ex426_ConvertBSTtoSortedList;

public class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * 题目需要把二叉搜索树, 转换为排序的双向链表
     */
    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }

        intervalTraversing(root);

        first.left = last;
        last.right = first;
        return first;
    }

    Node first;
    Node last;

    public void intervalTraversing(Node root) {
        if (root != null) {
            // 先进行左侧遍历
            intervalTraversing(root.left);
            // 中序部分进行链接
            if (last != null) {
                // 如果last不为空, 将其指向该节点
                last.right = root;
                root.left = last;
            } else {
                // 如果last为空, 可以认为是还没有链接节点, 将first置为自己
                first = root;
            }
            // 将last指向自己
            last = root;
            // 进行右侧遍历
            intervalTraversing(root.right);
        }

    }

}
