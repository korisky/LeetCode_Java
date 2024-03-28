package Ex1_300.Ex121_to_150.Ex146_LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 算法的要点在于:
 * 1. 使用一个双向链表用于存储访问的先后次序, 每次访问到的值, 先需要在原链表中断开, 然后add到头部
 * 如果新的值需要插入, 先判断链表是否超过capacity, 如果是则需要移除尾部
 * 2. 使用一个hashMap来存储内容, 方便判断是否有某个元素, 以及元素的值
 */
public class LRUCacheTest {


    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class NodeList {

        Node dumHead;
        Node dumTail;

        public NodeList() {
            this.dumHead = new Node(-1, -1);
            this.dumTail = new Node(-1, -1);
            dumHead.next = dumTail;
            dumTail.prev = dumHead;
        }

        // 获取尾部
        public Node getTail() {
            return dumTail.prev;
        }

        // 删除尾部
        public void cutTail() {
            Node cutNode = dumTail.prev;
            cutNode.prev.next = dumTail;
            dumTail.prev = cutNode.prev;
        }

        // 截断node, 由于使用双指针, 所以不要再遍历
        public void cutNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // 移到头部
        public void addToHead(Node node) {
            Node old = dumHead.next;
            old.prev = node;
            node.next = old;

            dumHead.next = node;
            node.prev = dumHead;
        }

    }


    int capacity;
    NodeList list;
    Map<Integer, Node> map; // 这里记住, value要保存node


    public LRUCacheTest(int capacity) {
        this.capacity = capacity;
        this.list = new NodeList();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 更新LRU-List
            Node node = map.get(key);
            list.cutNode(node);
            list.addToHead(node);
            // 返回value
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 更新LRU-List
            Node node = map.get(key);
            list.cutNode(node);
            node.val = value;
            list.addToHead(node);
            // 更新Map
            map.put(key, node);
        } else {
            Node node = new Node(key, value);
            list.addToHead(node);
            map.put(key, node);
            // 如果超出
            if (map.size() > capacity) {
                // cutTail
                Node tail = list.getTail();
                list.cutTail();
                // remove map
                map.remove(tail.key);
            }
        }
    }


}
