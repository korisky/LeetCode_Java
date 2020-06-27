package Ex61_to_90.Ex61_RotateList;

public class Solution {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        // 1. we need to get the length of the list
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int move = k % len; // this the real move we need
        if (move == 0)
            return head;

        // 2. use fast slow pointer, we need to get:
        // the cutting node's previous node, the last node
        ListNode preEnd = head;
        while (move-- > 0) {
            preEnd = preEnd.next;
        }
        ListNode newEnd = head;
        while (preEnd.next != null) {
            preEnd = preEnd.next;
            newEnd = newEnd.next;
        }

        // 3. 'rotate'
        ListNode newHead = newEnd.next;
        newEnd.next = null;
        preEnd.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        ListNode t6 = new ListNode(6);
        ListNode t5 = new ListNode(5);
        t5.next = t6;
        ListNode t4 = new ListNode(4);
        t4.next = t5;
        ListNode t3 = new ListNode(3);
        t3.next = t4;
        ListNode t2 = new ListNode(2);
        t2.next = t3;
        ListNode t1 = new ListNode(1);
        t1.next = t2;

        ListNode get = use.rotateRight(t1, 7);
        while (get != null) {
            System.out.println(get.val);
            get = get.next;
        }
    }
}
