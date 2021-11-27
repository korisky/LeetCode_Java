package Ex91_to_120.Ex116_PopulatingNextRightPointersInEachNode;

/**
 * 递归版本(更好理解), 使用递归的方式, 依次对左子树和右子树进行处理
 */
public class RecursiveSolution {
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
        // return null node
        if (root == null) {
            return null;
        }

        // let under level within pointing
        if (root.left != null) {
            root.left.next = root.right;
        }

        // let under level outer pointing
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        // go for left and right
        connect(root.left);
        connect(root.right);

        return root;
    }
}
