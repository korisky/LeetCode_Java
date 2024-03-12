package Ex901_1200.Ex1171_RemoveZeroSumConsecutive;

import java.util.Stack;

public class Solution {
    static class ListNode {
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

    public static ListNode removeZeroSumSubLists(ListNode head) {
        // conner case
        if (head == null || head.next == null) {
            return head;
        }
        // use stack
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode dumHead = new ListNode(10086);
        dumHead.next = head;
        nodeStack.push(dumHead);
        // traversing
        ListNode cur = head;
        while (cur != null) {
            if (!nodeStack.isEmpty() && (nodeStack.peek().val + cur.val == 0)) {
                nodeStack.pop();
            } else {
                nodeStack.push(cur);
            }
            cur = cur.next;
        }
        // pop to construct new list
        ListNode last = null;
        while (!nodeStack.isEmpty()) {
            cur = nodeStack.pop();
            cur.next = last;
            last = cur;
        }
        return last.next;
    }

    public static void main(String[] args) {

        ListNode last = new ListNode(-5);
        ListNode last2 = new ListNode(-2);
        last2.next = last;
        ListNode last3 = new ListNode(6);
        last3.next = last2;
        ListNode last4 = new ListNode(1);
        last4.next = last3;
        ListNode last5 = new ListNode(-4);
        last5.next = last4;
        ListNode last6 = new ListNode(-3);
        last5.next = last4;
        ListNode last7 = new ListNode(1);
        last5.next = last4;


        ListNode newHead = removeZeroSumSubLists(last5);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

}
