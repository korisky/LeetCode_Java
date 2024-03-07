package Ex1_300.Ex121_to_150.Ex147_InsertionSortList;

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

    public ListNode insertionSortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        // dump head
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode iter = dumpHead;
        // traverse
        while (iter.next != null) {
            if (iter.val > iter.next.val) {
                ListNode wrong = iter.next;
                iter.next = iter.next.next;
                // do insertion
                boolean inserted = false;
                ListNode insertIter = dumpHead;
                while (!inserted) {
                    if (insertIter.next == null) {
                        insertIter.next = wrong;
                        inserted = true;
                    }
                    if (insertIter.next.val > wrong.val) {
                        ListNode tmp = insertIter.next;
                        insertIter.next = wrong;
                        wrong.next = tmp;
                        inserted = true;
                    }
                    insertIter = insertIter.next;
                }
            } else {
                iter = iter.next;
            }
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
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
