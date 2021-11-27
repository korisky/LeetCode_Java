package Ex91_to_120.Ex117_PopulatingNextRightPointersInEachNodeII;

/**
 * 使用递归的方式进行处理, 最重要的点在于, 需要先遍历处理好所有右子树, 然后再处理左子树,
 * 因为我们的findNext方法, 如果该子树还没有next指向下一个子树, left子树可能就会误认为Point to null
 */
public class AnotherSolution {

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
        // first we make sure root is not null
        if (null == root) {
            return null;
        }
        // not perfect BST, need to take care with no right sub-tree situation
        if (root.left != null) {
            root.left.next = root.right != null ? root.right : findNext(root);
        }

        if (root.right != null) {
            root.right.next = findNext(root);
        }

        // Special, we need to connect all right trees first, then left, cause the pointer stuff is pointer towards right
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node findNext(Node root) {
        // because root is not null, root.next would not throw null pointer exception
        while (root.next != null) {
            root = root.next;
            if (root.left != null) {
                return root.left;
            }
            if (root.right != null) {
                return root.right;
            }
        }
        return null;
    }
}
