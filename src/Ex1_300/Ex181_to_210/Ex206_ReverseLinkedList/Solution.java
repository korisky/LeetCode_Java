package Ex1_300.Ex181_to_210.Ex206_ReverseLinkedList;

public class Solution {
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

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * Flexport possible interview: use this reverseList function to swap nodes in paris
     */
    public static void main(String[] args) {

        ListNode test1 = new ListNode(1, null);
        ListNode test2 = new ListNode(2, test1);
        ListNode test3 = new ListNode(3, test2);
        ListNode test4 = new ListNode(4, test3);
        ListNode test5 = new ListNode(5, test4);
        ListNode test6 = new ListNode(6, test5);
        ListNode test7 = new ListNode(7, test6);

        ListNode listNode = swapByReversed(test7, 2, 6);
        if (listNode.val > 1) {
            System.out.println("dsafsdf");
        }

    }

    /**
     * 不管长度如何一共4个步骤:
     * 1. 先找到第一个节点, 第二个节点位置, 将第二个节点next指针 pointTail 记录, 断开它
     * 2. 从第一个节点进行reversed
     * 3. 原第一个节点next指向pointTail, pointTail指向它, 而第一个节点的前一个断开.
     * 4. 从第二个节点的下一个进行reversed
     * 5. 原头部一直走到最后一个, 最后一个的next指向pointTail
     */
    public static ListNode swapByReversed(ListNode head, int val1, int val2) {
        ListNode extN1 = null;
        ListNode extN2 = null;
        ListNode headConnect = null;
        ListNode tailConnect = null;
        ListNode dumpHead = new ListNode(0);
        dumpHead.next = head;

        // step 1
        while (null != head) {
            if (head.val == val1 || head.val == val2) {
                if (extN1 == null) {
                    extN1 = head;
                } else {
                    extN2 = head;
                    break;
                }
            }
            if (extN1 == null) {
                headConnect = head;
            }
            head = head.next;
        }
        // cut off tail
        tailConnect = extN2.next;
        extN2.next = null;
        // cut off head
        headConnect.next = null;

        // step 2
        headConnect.next = reverseList(extN1);
        headConnect = headConnect.next;
        ListNode secondReversedHead = headConnect.next;
        headConnect.next = null;

        // step 3
        ListNode temp = secondReversedHead.next;
        ListNode tempPre = secondReversedHead;
        while (temp.next != null) {
            temp = temp.next;
            tempPre = tempPre.next;
        }
        temp.next = tailConnect;
        tailConnect = temp;
        tempPre.next = null;

        // step 4
        headConnect.next = reverseList(secondReversedHead);
        ListNode anotherTemp = headConnect.next;
        while (anotherTemp.next != null) {
            anotherTemp = anotherTemp.next;
        }
        anotherTemp.next = tailConnect;

        return dumpHead.next;
    }

}
