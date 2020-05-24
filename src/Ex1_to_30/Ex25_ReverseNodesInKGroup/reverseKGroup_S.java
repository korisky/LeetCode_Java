package Ex1_to_30.Ex25_ReverseNodesInKGroup;

/*
method form LeetCode:
    1. if curList's length is less than k, return head
    2. if not, reverse kth element
    3. then, recursionly call current function, with cur_head
    4. finally, return prev
 */

public class reverseKGroup_S {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        // do counting first
        ListNode temp = head;
        int listLength = 0;
        boolean longEnough = false;
        while (temp != null) {
            listLength++;
            if (listLength > k) { /////////// special situation!!!!!
                                    //////// If we use listLength++ in if statement instead of current code
                                    /////// we cannot get full reverse.
                longEnough = true;
                break;
            }
            temp = temp.next;
        }

        if (!longEnough)
            return head;

        // then we need to reverse it
        // we need to do the reverse every k's part
        ListNode curNode = head;
        ListNode preNode = null;
        int count = 0;
        while (curNode != null && count++ < k) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        head.next = reverseKGroup(curNode, k);
        return preNode;
    }


    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        t1.next = t2;
        ListNode t3 = new ListNode(3);
        t2.next = t3;
        ListNode t4 = new ListNode(4);
        t3.next = t4;
        ListNode t5 = new ListNode(5);
        t4.next = t5;
        ListNode t6 = new ListNode(6);
        t5.next = t6;
        ListNode t7 = new ListNode(7);
        t6.next = t7;

        reverseKGroup_S use = new reverseKGroup_S();

        ListNode head = use.reverseKGroup(t1, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
