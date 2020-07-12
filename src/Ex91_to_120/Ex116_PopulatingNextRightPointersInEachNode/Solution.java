package Ex91_to_120.Ex116_PopulatingNextRightPointersInEachNode;

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

    /**
     *
     * Rather then using slow queue to store and pop stuff, we can easily use the rules to do like:
     *
     * cur.right.next = cur.next.left
     */

    public Node connect(Node root) {
        Node level_start = root;
        while (level_start != null) {
            Node cur = level_start;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level_start = level_start.left;
        }
        return root;
    }
}
