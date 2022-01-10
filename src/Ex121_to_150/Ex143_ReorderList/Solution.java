package Ex121_to_150.Ex143_ReorderList;

/**
 * 实际就是不同长度reverse, 一直reverse到最后一个节点
 * 但是时间会过长
 */
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

    public void reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }
        // do the reverse from 1-n
        ListNode iter = head;
        while (iter.next != null) {
            iter.next = reverse(iter.next);
            iter = iter.next;
        }
    }

    public ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        s.reorderList(l1);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }


    }
}
