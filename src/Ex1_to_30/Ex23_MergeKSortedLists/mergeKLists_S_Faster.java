package Ex1_to_30.Ex23_MergeKSortedLists;

/*
IMP: 1. for merging two lists, we MUST use a new list, to store their nodes !!!!!!!
     2. If we need to Merge or Sort some SORTED stuff, try to remember QuickSort && MergeSort
     MergeSort can be implemented in ANY situation (such as this LIST stuff)
 */

public class mergeKLists_S_Faster {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        ListNode l1 = merge(lists, start, (start + end) / 2);
        ListNode l2 = merge(lists, (start + end) / 2 + 1, end);
        ListNode curMergeList = new ListNode(0);
        ListNode pointer = curMergeList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        while (l1 != null) {
            pointer.next = l1;
            l1 = l1.next;
            pointer = pointer.next;
        }
        while (l2 != null) {
            pointer.next = l2;
            l2 = l2.next;
            pointer = pointer.next;
        }
        return curMergeList.next;
    }

    public static void main(String[] args) {
        mergeKLists_S_Faster use = new mergeKLists_S_Faster();
        ListNode t_1 = new ListNode(1);
        ListNode t_2 = new ListNode(3);
        ListNode t_3 = new ListNode(5);
        t_1.next = t_2;
        t_2.next = t_3;

        ListNode w_1 = new ListNode(1);
        ListNode w_2 = new ListNode(2);
        ListNode w_3 = new ListNode(7);
        w_1.next = w_2;
        w_2.next = w_3;

        ListNode s_1 = new ListNode(4);
        ListNode s_2 = new ListNode(6);
        s_1.next = s_2;

        ListNode[] input = new ListNode[3];
        input[0] = t_1;
        input[1] = w_1;
        input[2] = s_1;

        ListNode result = use.mergeKLists(input);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
