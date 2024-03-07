package Ex1_300.Ex181_to_210.Ex206_ReverseLinkedList;

public class AnotherSol {


    public static Solution.ListNode extraPointer = null;


    public static void main(String[] args) {
        Solution.ListNode test1 = new Solution.ListNode(1, null);
        Solution.ListNode test2 = new Solution.ListNode(2, test1);
        Solution.ListNode test3 = new Solution.ListNode(3, test2);
        Solution.ListNode test4 = new Solution.ListNode(4, test3);
        Solution.ListNode test5 = new Solution.ListNode(5, test4);
        Solution.ListNode test6 = new Solution.ListNode(6, test5);
        Solution.ListNode test7 = new Solution.ListNode(7, test6);

        Solution.ListNode listNode = reverseList(test7);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }


    public static Solution.ListNode reverseList(Solution.ListNode head) {

        // 使用额外指针的方式
//        recursiveReverse(head);
//        return extraPointer;

        // 直接返回newHead的方式
        if (head == null || head.next == null) {
            return head;
        }

        Solution.ListNode newHead = reverseList(head.next);

        // 相较于操作newHead.next = head
        // 直接操作 head.next.next = newHead 可以直接避免修改nextNode, 使得可以返回tail为head
        head.next.next = newHead;
        head.next = null;
        return newHead;
    }

    public static Solution.ListNode recursiveReverse(Solution.ListNode curNode) {
        if (curNode.next == null) {
            // 额外的变量指向队尾, 也就是后来的队前
            extraPointer = curNode;
            return curNode;
        }
        Solution.ListNode nextNode = recursiveReverse(curNode.next);
        nextNode.next = curNode;
        curNode.next = null;
        return curNode;
    }
}
