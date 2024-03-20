package Ex1501_1800.Ex1669_MergeInBetweenLinkedLists;

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

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        // 快慢指针, 找到切入点
        ListNode fast = list1, slow = list1;
        int dif = b - a + 1;
        while (dif-- >= 0) {
            fast = fast.next;
        }
        while (a-- - 1 > 0) {
            slow = slow.next;
            fast = fast.next;
        }

        // cut进行拆解
        slow.next = list2;
        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = fast;
        return list1;
    }

    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode nine = new ListNode(9);
        nine.next = five;
        ListNode six = new ListNode(6);
        six.next = nine;
        ListNode thirteen = new ListNode(13);
        thirteen.next = six;
        ListNode one = new ListNode(1);
        one.next = thirteen;
        ListNode ten = new ListNode(10);
        ten.next = one;

        ListNode l2 = new ListNode(10002);
        ListNode l1 = new ListNode(10001);
        l1.next = l2;
        ListNode l = new ListNode(10000);
        l.next = l1;

        mergeInBetween(ten, 3, 4, l);
    }
}
