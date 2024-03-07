package Ex1_300.Ex1_to_30.Ex24_SwapNodesInPairs;

/*
Much more easier way: thinking about tracking to the tail of the list
the do swap, we can ignore the missing tail
 */

public class swapPairs_S_Easier {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head.next;
        head.next = swapPairs(p.next);
        p.next = head;
        return p;
    }

    public static void main(String[] args) {
        swapPairs_S_Easier use = new swapPairs_S_Easier();
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        t1.next = t2;
        ListNode t3 = new ListNode(3);
        t2.next = t3;
        ListNode t4 = new ListNode(4);
        t3.next = t4;
        ListNode t5 = new ListNode(5);
        t4.next = t5;

        ListNode head = use.swapPairs(t1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
