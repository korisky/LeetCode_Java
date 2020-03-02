package Ex_1_to_30.Ex19_RemoveNthNodeFromEndOfList;

/*
method: use fast & slow pointer, their interval would be the input n, as
which one we wanna delete. when faster point to the null, slow pointer would
be the node that point to the expected-delete node.
 */

public class removeNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head.next == null)
            return null;
        int temp = n;
        int count = 0;
        ListNode slower = head;
        ListNode faster = head;
        while (temp-- + 1 != 0 && faster != null) {
            faster = faster.next;
            count++;
        }
        while (faster != null) {
            faster = faster.next;
            slower = slower.next;
            count++;
        }
        if (count == n)
            return head.next;
        if (slower.next != null)
            slower.next = slower.next.next;
        return head;
    }


    public static void main(String[] args) {
//        ListNode t5 = new ListNode(5);
//        ListNode t4 = new ListNode(4);
//        t4.next = t5;
//        ListNode t3 = new ListNode(3);
//        t3.next = t4;
//        ListNode t2 = new ListNode(2);
//        t2.next = t3;
//        ListNode t1 = new ListNode(1);
//        t1.next = t2;

//        ListNode t2 = new ListNode(2);
        ListNode t1 = new ListNode(1);
//        t1.next = t2;

        removeNthFromEnd use = new removeNthFromEnd();
        ListNode newHead = use.removeNthFromEnd(t1, 1);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
