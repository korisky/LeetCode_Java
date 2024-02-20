package Ex151_to_180.Ex160_IntersectionTwoLinkedLists;

/**
 * tips: 虽然两个链表长度不同, 要找到交汇点不能单纯的参考快慢指针
 * 可以考虑, 当遍历a链表到尾部null时, 再让其到达b链表的head, 而b链表也类似
 * 这样, 当a和b相同, 即为交汇点. 如果没有交汇点, 也会相交于null
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (null == headA || null == headB) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (null == a) ? headB : a.next;
            b = (null == b) ? headA : b.next;
        }

        return a;
    }
}
