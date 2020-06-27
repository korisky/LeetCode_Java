package Ex61_to_90.Ex83_RemoveDuplicatesFromSortedList;

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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode pre = preHead;
        ListNode cur = head.next;
        while (cur != null) {
            if (pre.next.val == cur.val) { // duplicated value
                pre.next = cur;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        ListNode t1 = new ListNode(3);
        ListNode t2 = new ListNode(3);
        ListNode t3 = new ListNode(2);
        ListNode t4 = new ListNode(1);
        ListNode t5 = new ListNode(1);
        t5.next = t4;
        t4.next = t3;
        t3.next = t2;
        t2.next = t1;
        use.deleteDuplicates(t5);
    }
}
