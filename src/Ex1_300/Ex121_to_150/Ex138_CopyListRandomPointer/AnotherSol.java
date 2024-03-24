package Ex1_300.Ex121_to_150.Ex138_CopyListRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 针对更快速的construct, 第一遍进行copy是使用一个Map存储random
 */
public class AnotherSol {
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

        // conner
        if (head == null) {
            return null;
        }

        // init map
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        Node deepDumHead = new Node(0);
        Node deepCur = deepDumHead;

        // 第一次遍历, 生成deepCopy, 并且dum作为新的copy的head,
        // 而prev类似一个指针, 将deepCopy出来的按顺序链接, 也就是将next进行正确指向, O(n)
        while (cur != null) {
            // deep copy & put into map
            Node node = new Node(cur.val);
            map.put(cur, node);
            // iteration
            deepCur.next = node;
            deepCur = deepCur.next;
            // loop
            cur = cur.next;
        }

        // 第二次遍历, 将random进行正确指向, O(n)
        cur = head;
        while (cur != null) {
            // 获取当前节点的deepCopy版本
            Node deepRanStart = map.get(cur);
            // 这个deepCopy的random, 就是原random放入map中的deepCopy版本
            deepRanStart.random = map.get(cur.random);
            cur = cur.next;
        }
        return deepDumHead.next;
    }
}
