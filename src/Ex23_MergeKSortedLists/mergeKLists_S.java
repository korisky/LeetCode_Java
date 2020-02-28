package Ex23_MergeKSortedLists;

import java.util.ArrayList;
import java.util.List;

public class mergeKLists_S {
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
        ListNode head = new ListNode(0);
        ListNode cur = head;
        boolean added = true;
        while (added) {
            added = false;
            int choosingNode = 0;
            int minNodeVal = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null && node.val < minNodeVal) {
                    minNodeVal = node.val;
                    choosingNode = i;
                    added = true;
                }
            }
            if (added) {
                cur.next = lists[choosingNode];
                lists[choosingNode] = lists[choosingNode].next;
                cur = cur.next;
            } else {
                break;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        mergeKLists_S use = new mergeKLists_S();
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
