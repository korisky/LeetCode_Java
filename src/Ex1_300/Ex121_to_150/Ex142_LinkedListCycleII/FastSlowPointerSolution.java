package Ex1_300.Ex121_to_150.Ex142_LinkedListCycleII;

/**
 * 先快慢指针找到重合点, 随后一步一步, 一个新的节点从head走,
 * slow也一步一步走, 当slow与head走到一起, 那个点就是开始循环的点
 */
public class FastSlowPointerSolution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
