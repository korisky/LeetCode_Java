package Ex_1_to_30.Ex25_ReverseNodesInKGroup;

/*
method form LeetCode:
    1. if curList's length is less than k, return head
    2. if not, reverse kth element
    3. then, recursionly call current function, with cur_head
    4. finally, return prev
 */

public class reverseKGroup_S {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode countLen = head;
        int len = 0;
        while (countLen != null) {
            len++;
            countLen = countLen.next;
        }
        if (len < k)
            return head;
        // else, we need to reverse it
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = head;
        int count = 0;
        while (cur != null && count < k) {
            count++;
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        head.next = reverseKGroup(cur, k);
        return pre;
    }


    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        t1.next = t2;
        ListNode t3 = new ListNode(3);
        t2.next = t3;
        ListNode t4 = new ListNode(4);
        t3.next = t4;
        ListNode t5 = new ListNode(5);
        t4.next = t5;
        ListNode t6 = new ListNode(6);
        t5.next = t6;
        ListNode t7 = new ListNode(7);
        t6.next = t7;

        reverseKGroup_S use = new reverseKGroup_S();

        ListNode head = use.reverseKGroup(t1, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
