package Ex1_300.Ex1_to_30.Ex25_ReverseNodesInKGroup;


import java.util.LinkedList;
import java.util.List;

public class AnotherSol {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 切分3个步骤
     * 1) 每k个进行分段, 最后无法分段的部分单独保存(那一段是不需要反转的)
     * 2) 对分段都进行reverse
     * 3) reverse的都进行前后链接, 最后一个节点将剩余的段的头进行链接
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        List<ListNode> needReverseLists = new LinkedList<>();

        // 1. 每k个node进行切分, 时间复杂度: O(n), 只会遍历一次
        ListNode iter = head;
        ListNode curHead = null;
        while (iter != null) {
            // 尝试进行分段
            int curLen = 1;
            curHead = iter;
            while (iter != null && curLen++ < k) {
                iter = iter.next;
            }
            // 如果已经超出, 直接停止
            if (iter == null) {
                break;
            }
            // 切分
            ListNode tail = iter.next;
            iter.next = null;
            iter = tail;
            // 保存分段的头部
            needReverseLists.add(curHead);
        }

        // 2. 进行reverse & 拼接 (注意拼接要到最后一位), 时间复杂度: O(n), 因为不会超过原链表总长度
        ListNode dum = new ListNode(0);
        iter = dum;
        for (ListNode oldHead : needReverseLists) {
            iter.next = reverse(oldHead);
            while (iter.next != null) {
                iter = iter.next;
            }
        }

        // 3. 拼接剩余
        iter.next = curHead;
        return dum.next;
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
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

        AnotherSol use = new AnotherSol();

        ListNode head = use.reverseKGroup(t1, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

    }
}
