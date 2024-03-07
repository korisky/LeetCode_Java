package Ex1_300.Ex1_to_30.Ex23_MergeKSortedLists;

import java.util.*;

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
     * 考虑对每一条链进行遍历, 使用一个priorityQueue更快的对当前头节点筛选最小的进行获取
     */
    public ListNode mergeKLists(ListNode[] lists) {

        // conner case
        if (lists == null) {
            return new ListNode();
        }

        // 新建dumHead
        ListNode dumHead = new ListNode(0);
        ListNode cur = dumHead;

        // 默认从小到大排, 头部进行保存
        Queue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        while (!priorityQueue.isEmpty()) {
            // 取出最小的
            ListNode node = priorityQueue.poll();
            // 维持指针
            cur.next = node;
            cur = node;
            // 添加
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }

        return dumHead.next;
    }

}
