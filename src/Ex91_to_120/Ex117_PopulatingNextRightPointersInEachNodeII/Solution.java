package Ex91_to_120.Ex117_PopulatingNextRightPointersInEachNodeII;

public class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;

        if (root.left != null)
            root.left.next = (root.right != null) ? root.right : findNext(root.next);

        if (root.right != null)
            root.right.next = findNext(root.next);

        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node findNext(Node root) {
        while (root != null) {
            root = root.next;
            if (root.left != null)
                return root.left;
            if (root.right != null)
                return root.right;
        }
        return null;
    }
}
