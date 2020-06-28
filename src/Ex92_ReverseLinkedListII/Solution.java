package Ex92_ReverseLinkedListII;

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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int curIdx = 0;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        ListNode start = null;
        ListNode reverseStart = null;
        ListNode end = null;
        while (cur != null) {
            curIdx++;
            if (curIdx == m) {
                start = cur;
                reverseStart = cur.next;
                cur = cur.next;
                start.next = null;
            } else if (curIdx == n + 1) {
                end = cur.next;
                cur.next = null;
                break;
            } else {
                cur = cur.next;
            }
        }

        ListNode reversedHead = reverseList(reverseStart);
        start.next = reversedHead;
        cur = reversedHead;
        while (cur.next != null)
            cur = cur.next;
        cur.next = end;
        return newHead.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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

        ListNode res = use.reverseBetween(t1, 3, 4);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
