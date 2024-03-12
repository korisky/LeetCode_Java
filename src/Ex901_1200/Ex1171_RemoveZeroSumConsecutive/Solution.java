package Ex901_1200.Ex1171_RemoveZeroSumConsecutive;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    static class ListNode {
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

    public static ListNode removeZeroSumSubLists_OnlyForSimpleSum(ListNode head) {
        // conner case
        if (head == null || head.next == null) {
            return head;
        }
        // use stack
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode dumHead = new ListNode(10086);
        dumHead.next = head;
        nodeStack.push(dumHead);
        // traversing
        ListNode cur = head;
        while (cur != null) {
            if (!nodeStack.isEmpty() && (nodeStack.peek().val + cur.val == 0)) {
                nodeStack.pop();
            } else {
                nodeStack.push(cur);
            }
            cur = cur.next;
        }
        // pop to construct new list
        ListNode last = null;
        while (!nodeStack.isEmpty()) {
            cur = nodeStack.pop();
            cur.next = last;
            last = cur;
        }
        return last.next;
    }

    /**
     * 非常优秀的处理方式
     */
    public static ListNode removeZeroSumSubLists(ListNode head) {

        // 通用准备方式
        int prefix = 0;
        ListNode dumHead = new ListNode(0);
        dumHead.next = head;

        // 第一次遍历, 持续累加, 通过计算可以发现, 如果出现累加值相等的情况, 实际上中间就是求和为0 (++--然后重新到同一个值)
        Map<Integer, ListNode> seen = new HashMap<>();
        seen.put(0, dumHead);
        for (ListNode i = dumHead; i != null; i = i.next) {
            prefix += i.val;
            seen.put(prefix, i);
        }

        // 第二次遍历, 继续持续累加, 但此次累加进行取值, 由于上一次遍历时相同的值会被更新, 所以这里直接获取到可以跳过的部分
        prefix = 0;
        for (ListNode i = dumHead; i != null; i = i.next) {
            prefix += i.val;
            i.next = seen.get(prefix).next;
        }
        return dumHead.next;
    }


    public static void main(String[] args) {

        ListNode last = new ListNode(-5);
        ListNode last2 = new ListNode(-2);
        last2.next = last;
        ListNode last3 = new ListNode(6);
        last3.next = last2;
        ListNode last4 = new ListNode(1);
        last4.next = last3;
        ListNode last5 = new ListNode(-4);
        last5.next = last4;
        ListNode last6 = new ListNode(-3);
        last6.next = last5;
        ListNode last7 = new ListNode(1);
        last7.next = last6;


        ListNode newHead = removeZeroSumSubLists(last5);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

}
