package Ex121_to_150.Ex143_ReorderList;

/**
 * 实际就是不同长度reverse, 一直reverse到最后一个节点
 * 但是时间会过长
 */
public class FastPointerSolution {
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
        ListNode midNode = midNode(head);
        ListNode nextToMid = midNode.next;
        midNode.next = null;
        ListNode p2 = reverse(nextToMid);
        ListNode p1 = head;
        ListNode p1Next;
        while (null != p1 && null != p2) {
            p1Next = p1.next;
            p1.next = p2;
            p1 = p2;
            p2 = p1Next;
        }
    }

    // use the fast slow pointer, fast one just 2x step each time
    // then once fast pointer reach the end, then slow pointer
    // must point to the mid point
    public ListNode midNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (null != cur) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        FastPointerSolution s = new FastPointerSolution();
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
