package Ex2101_2400.Ex2181_MergeNodesBetweenZeros;

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

    /**
     * 题目需要将链表0之间的数字进行求和, 得到新的链表,
     * 相较于反向递归, 实际上直接按顺序用额外空间更加简单
     */
    public static ListNode mergeNodes(ListNode head) {
        ListNode sumPreHead = new ListNode(0);
        ListNode sumIter = sumPreHead;
        int tmpSum = 0;
        while (head != null) {
            if (head.val == 0 && tmpSum > 0) {
                sumIter.next = new ListNode(tmpSum);
                tmpSum = 0;
                sumIter = sumIter.next;
            }
            tmpSum += head.val;
            head = head.next;
        }
        return sumPreHead.next;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(2, n0);
        ListNode n2 = new ListNode(5, n1);
        ListNode n3 = new ListNode(4, n2);
        ListNode n4 = new ListNode(0, n3);
        ListNode n5 = new ListNode(1, n4);
        ListNode n6 = new ListNode(3, n5);
        ListNode n7 = new ListNode(0, n6);

        ListNode newHead = mergeNodes(n7);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

}
