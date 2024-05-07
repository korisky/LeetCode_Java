package Ex2816_RepresentedLinkedList;

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


    int add = 0;

    /**
     * 尝试使用递归的方式, 先到达最后一位, 然后反向x2
     */
    public ListNode doubleIt(ListNode head) {
        recursiveMulti(head);
        if (add != 0) {
            ListNode more = new ListNode(add);
            more.next = head;
            return more;
        }
        return head;
    }

    private ListNode recursiveMulti(ListNode head) {
        if (head == null) {
            return head;
        }
        recursiveMulti(head.next);
        int mul2 = head.val * 2 + add;
        head.val = mul2 % 10;
        add = mul2 / 10;
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode one = new ListNode(1);
        ListNode eight = new ListNode(8);
        ListNode nine = new ListNode(9);
        one.next = eight;
        eight.next = nine;

        ListNode multi = s.doubleIt(one);
        while (multi != null) {
            System.out.println(multi.val);
            multi = multi.next;
        }
    }
}
