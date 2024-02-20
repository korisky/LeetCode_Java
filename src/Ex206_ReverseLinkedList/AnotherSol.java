package Ex206_ReverseLinkedList;

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
        recursiveReverse(head);
        return extraPointer;
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
