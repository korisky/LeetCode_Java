package Ex24_SwapNodesInPairs;

/*
remember to add pHead(0), it would make list's operations much more easier
 */

public class swapPairs_S {
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

        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode curNode = pHead;

        while (curNode.next != null && curNode.next.next != null) {
            ListNode swapLeftPointer = curNode.next;
            curNode.next = curNode.next.next;
            ListNode endPointer = curNode.next.next;
            curNode.next.next = swapLeftPointer;
            curNode.next.next.next = endPointer;
            curNode = curNode.next.next;
        }

        return pHead.next;
    }

    public static void main(String[] args) {
        swapPairs_S use = new swapPairs_S();
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
