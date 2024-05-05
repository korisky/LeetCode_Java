package Ex1_300.Ex211_to_240.Ex237_DeleteNodeLinkedList;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 题目给出的节点就是链表中需要被删除的节点, 由于无法获取上一个节点, 这里可以考虑“复制”下一个节点, 然后删除下一个节点来达到类似效果
     */
    public void deleteNode(ListNode node) {

        // 已经到达链尾
        if (node.next == null) {
            node = null;
            return;
        }

        // 后面至少一个节点
        ListNode nexNode = node.next;
        node.next = nexNode.next;
        node.val = nexNode.val;
    }
}
