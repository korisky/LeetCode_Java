package Ex1_to_30.Ex2_AddTwoNum;

/*
# Example:
#
# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8
# Explanation: 342 + 465 = 807.
 */

// The main point here is about: l1 and l2 might has different size, but we still
// need to add them together: e.g. 1 + 1->2->3 = 2->2->3
// thus, when we traversing l1 and l2, we only point to their next
// when current l1 or l2 is not NULL

public class addTwoNums {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        int acc = 0;
        while (l1 != null || l2 != null || acc != 0) {
            int curSum = 0;
            if (l1 != null) {
                curSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                curSum += l2.val;
                l2 = l2.next;
            }
            if (acc != 0)
                curSum++;

            acc = curSum / 10;
            curNode.next = new ListNode(curSum % 10);
            curNode = curNode.next;
        }
        return head.next;
    }

}
