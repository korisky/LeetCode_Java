package Ex121_to_150.Ex147_InsertionSortList;

/**
 * 方法重点在于, 如果当前需要插入的node的值已经大于前一个, 而由于前面的都是sorted的了, 所以
 * 可以从这个点开始往后找插入点
 */
public class FasterSolution {
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

    public ListNode insertionSortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        // dump head
        ListNode dumpHead = new ListNode(-1);
        ListNode pre = dumpHead;
        while (head != null) {
            ListNode tmp = head.next;
            // Only the last node's val is > then the current inserting node, should we
            // move to the head again to find the correct pos to insert
            if (pre.val >= head.val) {
                pre = dumpHead;
            }
            // run to the wrong node
            while (pre.next != null && pre.next.val < head.val) {
                pre = pre.next;
            }
            // replace
            head.next = pre.next;
            pre.next = head;
            // rather then set it return to head, we just keep
            // searching from the place we replace
            head = tmp;
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        FasterSolution s = new FasterSolution();
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n2.next = n1;
        ListNode n3 = new ListNode(4);
        n3.next = n2;
//        ListNode listNode =  s.insertFromHead(n2, new ListNode(3));
        ListNode listNode = s.insertionSortList(n3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
