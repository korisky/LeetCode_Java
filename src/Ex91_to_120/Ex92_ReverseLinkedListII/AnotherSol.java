package Ex91_to_120.Ex92_ReverseLinkedListII;

public class AnotherSol {

    static Solution.ListNode extraTail = null;


    public static void main(String[] args) {
        Solution.ListNode t5 = new Solution.ListNode(5);
        Solution.ListNode t4 = new Solution.ListNode(4);
        t4.next = t5;
        Solution.ListNode t3 = new Solution.ListNode(3);
        t3.next = t4;
        Solution.ListNode t2 = new Solution.ListNode(2);
        t2.next = t3;
        Solution.ListNode t1 = new Solution.ListNode(1);
        t1.next = t2;


//        Solution.ListNode t5 = new Solution.ListNode(3);
//        Solution.ListNode t4 = new Solution.ListNode(2);
//        t4.next = t5;
//        Solution.ListNode t3 = new Solution.ListNode(1);
//        t3.next = t4;

        Solution.ListNode res = reverseBetween(t1, 2, 4);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }

    /**
     * 可以通过添加当前idx来进行判断, 此时应该进行reverse返回newHead, 还是直接返回head
     */
    public static Solution.ListNode reverseBetween(Solution.ListNode head, int left, int right) {
        // 避免扭转直接返回
        if (left == right) {
            return head;
        }
        // 使用一个额外的dummyHead, 用来处理当扭转的left为1的情况
        Solution.ListNode dumHead = new Solution.ListNode(0);
        dumHead.next = head;
        return reverse(dumHead, 0, left, right).next;
    }

    public static Solution.ListNode reverse(Solution.ListNode head, int curIdx, int left, int right) {

        // 终止部分
        if (head == null || head.next == null) {
            return head;
        }

        // 同样的进行recursive递归, 注意这里的idx+1传入
        Solution.ListNode newHead = reverse(head.next, curIdx + 1, left, right);

        // 添加一个布尔值判断返回具体哪个Node
        boolean reversed = false;

        // 这里复杂在于, 1) 需要reverse的时候不是 curIdx == right, 而是< 要上一个, 2) 并且不能影响到不需要reverse的部分
        if (curIdx < right && curIdx >= left) {
            if (extraTail == null) {
                // record tail
                extraTail = newHead.next;
            }
            head.next.next = head;
            head.next = null;
            reversed = true;
        }

        // 这里是额外处理, 当回到不需要reverse时, 额外将extra补回去
        if (curIdx == left - 1) {
            head.next.next = extraTail;
            head.next = newHead;
        }

        // else return head
        return reversed ? newHead : head;
    }
}
