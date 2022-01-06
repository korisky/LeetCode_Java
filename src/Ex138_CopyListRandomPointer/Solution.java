package Ex138_CopyListRandomPointer;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
 * 在同一条链表上进行复制, 首先在同一链表上每个节点的next指向的是自己的一个copy,
 * 然后第二遍遍历, 将random指向的赋值到copy上, 注意是指向random的copy,
 * 第三遍遍历, 将original与copy的两个list进行分离
 */
public class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node iter = head;
        // step 1, make copy of each node, only copy their next
        while (iter != null) {
            // deep copy
            Node copy = new Node(iter.val);
            copy.next = iter.next;
            // each node point next to it's copy
            iter.next = copy;
            // keep iterating
            iter = copy.next;
        }
        // step 2, copy the random pointer to the copy nodes
        iter = head;
        while (iter != null) {
            // we need to make the copy node, random point to corresponding copy node
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        // step 3, separate old list and copy list
        iter = head;
        Node preHead = new Node(0);
        Node copyIter = preHead;
        while (iter != null) {
            // split copy list
            Node copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            // cut copy from original list
            iter.next = iter.next.next;
            iter = iter.next;
        }
        return preHead.next;
    }
}
