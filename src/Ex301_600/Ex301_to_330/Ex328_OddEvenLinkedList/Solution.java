package Ex301_600.Ex301_to_330.Ex328_OddEvenLinkedList;

public class Solution {


    /**
     * 题目需要将奇数位全部前移, 偶数后移, 核心在于使用两个指针各自skip一个next, 不相互影响, 最后再整合成一条链
     */
    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return head;
        }

        // 奇数和偶数各自next跳过
        ListNode odd = head, even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        // 最后链接末尾
        odd.next = evenHead;
        return head;
    }

    public class ListNode {
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
}
