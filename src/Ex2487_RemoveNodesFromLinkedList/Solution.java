package Ex2487_RemoveNodesFromLinkedList;

import java.util.Stack;

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

    /**
     * 题目需要删除节点, 如果节点的右边存在一个大于它的节点, 这里可以使用栈进行操作, Ex237的复杂版
     */
    public ListNode removeNodes(ListNode head) {

        // 使用栈的FILO特性
        Stack<ListNode> remain = new Stack<>();
        while (head != null) {
            while (!remain.isEmpty()) {
                if (remain.peek().val >= head.val) {
                    break;
                }
                remain.pop();
            }
            remain.push(head);
            head = head.next;
        }

        // 按照顺序进行提取
        ListNode dumHead = new ListNode(0);
        head = dumHead;
        for (ListNode listNode : remain) {
            head.next = listNode;
            head = head.next;
        }
        return dumHead.next;
    }
}
