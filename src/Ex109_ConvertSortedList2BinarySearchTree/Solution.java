package Ex109_ConvertSortedList2BinarySearchTree;

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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        this.head = head;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        return helper(n);
    }

    public TreeNode helper(int n) {
        if (n <= 0)
            return null;
        TreeNode left = helper(n / 2);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        root.right = helper(n - n / 2 - 1);
        return root;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        ListNode t5 = new ListNode(5);
        ListNode t4 = new ListNode(4);
        t4.next = t5;
        ListNode t3 = new ListNode(3);
        t3.next = t4;
        ListNode t2 = new ListNode(2);
        t2.next = t3;
        ListNode t1 = new ListNode(1);
        t1.next = t2;
        TreeNode treeNode = use.sortedListToBST(t1);
        System.out.println(treeNode.toString());
    }
}
