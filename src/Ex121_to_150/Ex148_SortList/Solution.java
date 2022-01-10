package Ex121_to_150.Ex148_SortList;

/*
    The question need us only using constant space (O(1)),
    if not, we can use Merge Sort method to separate the linked list in halve
    then merge them together.

    Merge Sort solution would be much more faster
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

    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode [] list = new ListNode[2];
        boolean done = (null == head);
        // Keep partitioning our list into bigger sublists length.
        // Starting with a size of 1 and doubling each time
        for (int step = 1; !done; step *= 2) {
            done = true;
            ListNode prev = dummy;
            ListNode remaining = prev.next;
            do {
                // Split off two sublists of size step
                for (int i = 0; i < 2; ++i) {
                    list[i] = remaining;
                    ListNode tail = null;
                    for (int j = 0; j < step && null != remaining; ++j, remaining = remaining.next) {
                        tail = remaining;
                    }
                    // Terminate our sublist
                    if (null != tail) {
                        tail.next = null;
                    }
                }

                // We're done if these are the first two sub-lists in this pass and they
                // encompass the entire primary list
                done &= (null == remaining);

                // If we have two sublists, merge them into one
                if (null != list[1]) {
                    while (null != list[0] || null != list[1]) {
                        int idx = (null == list[1] || null != list[0] && list[0].val <= list[1].val) ? 0 : 1;
                        prev.next = list[idx];
                        list[idx] = list[idx].next;
                        prev = prev.next;
                    }

                    // Terminate our new sublist
                    prev.next = null;
                } else {
                    // Only a single sublist, no need to merge, just attach to the end
                    prev.next = list[0];
                }
            } while (null != remaining);
        }
        return dummy.next;
    }
}
