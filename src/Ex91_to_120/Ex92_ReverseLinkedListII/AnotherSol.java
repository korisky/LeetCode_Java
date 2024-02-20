package Ex91_to_120.Ex92_ReverseLinkedListII;

public class AnotherSol {

    static Solution.ListNode extraTail = null;


    public static void main(String[] args) {
//        Solution.ListNode t5 = new Solution.ListNode(5);
//        Solution.ListNode t4 = new Solution.ListNode(4);
//        t4.next = t5;
//        Solution.ListNode t3 = new Solution.ListNode(3);
//        t3.next = t4;
//        Solution.ListNode t2 = new Solution.ListNode(2);
//        t2.next = t3;
//        Solution.ListNode t1 = new Solution.ListNode(1);
//        t1.next = t2;


        Solution.ListNode t5 = new Solution.ListNode(3);
        Solution.ListNode t4 = new Solution.ListNode(2);
        t4.next = t5;
        Solution.ListNode t3 = new Solution.ListNode(1);
        t3.next = t4;

        Solution.ListNode res = reverseBetween(t3, 1, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }


    public static Solution.ListNode reverseBetween(Solution.ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        return reverse(head, 1, left, right);
    }

    public static Solution.ListNode reverse(Solution.ListNode head, int curIdx, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }

        Solution.ListNode newHead = reverse(head.next, curIdx + 1, left, right);

        // need reverse
        boolean reversed = false;
        if (curIdx < right && curIdx >= left) {
            if (curIdx == right - 1) {
                // record tail
                extraTail = newHead.next;
            }
            head.next.next = head;
            head.next = null;
            reversed = true;
        }

        if (curIdx == left - 1 || curIdx == 1) {
            head.next.next = extraTail;
            head.next = newHead;
        }

        // else return head
        return reversed ? newHead : head;
    }
}
