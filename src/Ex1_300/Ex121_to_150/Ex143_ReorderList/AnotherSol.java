package Ex1_300.Ex121_to_150.Ex143_ReorderList;

public class AnotherSol {

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
     * 想法:
     * 1. 快慢指针对链进行拆分, 保留前一半链与后一半链
     * 2. 后一半链进行翻转
     * 3. 合并2条链
     */
    public static void reorderList(ListNode head) {

        // conner case
        if (head == null || head.next == null) {
            return;
        }

        // init
        ListNode dumHead = new ListNode(0);
        dumHead.next = head;
        ListNode slow = head, fast = head;

        // 1. 快慢指针切分 (刚好复合题目需要的前半部分)
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 翻转后半部分链
        ListNode reversed = reverse(slow.next);
        slow.next = null;

        // 3. 间隔merge
        mergeInterval(dumHead, dumHead.next, reversed);

        // reference -> 修改指向
        head = dumHead.next;
    }

    public static void mergeInterval(ListNode dumHead, ListNode l, ListNode r) {

        boolean useL = true;
        ListNode iter = dumHead;
        while (l != null && r != null) {
            if (useL) {
                iter.next = l;
                l = l.next;
            } else {
                iter.next = r;
                r = r.next;
            }
            iter = iter.next;
            useL = !useL;
        }

        while (l != null) {
            iter.next = l;
            l = l.next;
            iter = iter.next;
        }

        while (r != null) {
            iter.next = r;
            r = r.next;
            iter = iter.next;
        }
    }


    public static ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode reverseHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        reorderList(l1);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }


    }
}
