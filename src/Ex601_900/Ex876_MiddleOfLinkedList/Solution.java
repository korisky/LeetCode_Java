package Ex601_900.Ex876_MiddleOfLinkedList;

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


    /**
     * 获取LinkedList的中间节点, 可以很快的考虑到快慢指针直接获取中间
     */
    public ListNode middleNode(ListNode head) {

        // conner case
        if (head == null || head.next == null) {
            return head;
        }

        // 快慢指针, 这里要注意fast.next != null也要判断不然npe
        ListNode slow = head;
        ListNode fast = slow;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 根据fast.next究竟是不是队尾, 可以判断需要返回slow还是slow的下一个
        return fast.next != null ? slow.next : slow;
    }
}
