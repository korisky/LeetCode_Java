package Ex1_300.Ex121_to_150.Ex148_SortList;

public class AnotherSol {

    /**
     * MergeSort 归并排序作用于链表,
     * 实际下列使用递归, 时间复杂度是O(nLogN), 但空间复杂度不符合O(1)
     * 若要达到O(1)的空间复杂度，则需要考虑, 不递归调用, 而是通过步长(stepSize = stepSize * 2)来进行排序
     */
    public ListNode sortList_MergeSortSolution(ListNode head) {

        // 1. 返回不需要sort的部分
        if (head == null || head.next == null) {
            return head;
        }

        // 2. 通过快慢指针切分链表, slow 将会是在中间
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 3. 切断链表方便处理
        prev.next = null;

        // 4. MergeSort中的切分, 递归调用
        ListNode left = sortList_MergeSortSolution(head);
        ListNode right = sortList_MergeSortSolution(slow);

        // 5. MergeSort中的归并
        return mergeOps(left, right);
    }

    public ListNode mergeOps(ListNode l, ListNode r) {
        // 链表使用一个dumpHead
        ListNode head = new ListNode(0);
        ListNode tail = head;
        // sort
        while (l != null && r != null) {
            if (l.val < r.val) {
                tail.next = l;
                l = l.next;
            } else {
                tail.next = r;
                r = r.next;
            }
            tail = tail.next;
        }
        // 某条链长
        if (l != null) {
            tail.next = l;
        }
        if (r != null) {
            tail.next = r;
        }
        // 返回dumpHead的下一个
        return head.next;
    }


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
}
