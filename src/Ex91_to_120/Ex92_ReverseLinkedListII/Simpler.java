package Ex91_to_120.Ex92_ReverseLinkedListII;

public class Simpler {
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        for (int i = 1; i < m; i++)
            pre = pre.next; // let pre point to the node that just before the reverse

        ListNode start = pre.next;
        ListNode post = start.next;

        for (int i = 1; i < n - m + 1; i++) {
            start.next = post.next;
            post.next = pre.next;
            pre.next = post;
            post = start.next;
        }

        return preHead.next;
    }
}
