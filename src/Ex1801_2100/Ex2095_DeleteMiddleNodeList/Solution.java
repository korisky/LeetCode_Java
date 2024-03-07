package Ex1801_2100.Ex2095_DeleteMiddleNodeList;

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

    public ListNode deleteMiddle(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast = preHead;
        ListNode slow = preHead;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return preHead.next;
    }

}
