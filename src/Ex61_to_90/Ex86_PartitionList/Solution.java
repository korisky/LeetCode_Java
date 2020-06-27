package Ex61_to_90.Ex86_PartitionList;

/*
    Idea is about, using two pointer, to make a list that contain only element that less than s,
    and a list that only contain element greater than x.
 */

public class Solution {
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

    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode less = new ListNode(0);
        ListNode lessCur = less;
        ListNode great = new ListNode(0);
        ListNode greatCur = great;
        while (cur != null) {
            if (cur.val < x) {
                lessCur.next = cur;
                cur = cur.next;
                lessCur = lessCur.next;
                lessCur.next = null;
            } else {
                greatCur.next = cur;
                cur = cur.next;
                greatCur = greatCur.next;
                greatCur.next = null;
            }
        }
        lessCur.next = great.next;
        return less.next;
    }
}
