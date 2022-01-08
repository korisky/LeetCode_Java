package Ex146_LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 算法的要点在于:
 *  1. 使用一个双向链表用于存储访问的先后次序, 每次访问到的值, 先需要在原链表中断开, 然后add到头部
 *      如果新的值需要插入, 先判断链表是否超过capacity, 如果是则需要移除尾部
 *  2. 使用一个hashMap来存储内容, 方便判断是否有某个元素, 以及元素的值
 */
public class LRUCache {

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LinkedNodeList {
        Node dummyHead;
        Node dummyTail;

        public LinkedNodeList() {
            dummyHead = new Node(0, 0);
            dummyTail = new Node(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        void moveToHead(Node node) {
            // 1. connect prev & next
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 2. add as new head
            addToHead(node);
        }

        void addToHead(Node node) {
            Node tmp = dummyHead.next;
            dummyHead.next = node;
            node.prev = dummyHead;
            node.next = tmp;
            tmp.prev = node;
        }

        void removeTail() {
            Node newTail = dummyTail.prev.prev;
            newTail.next = dummyTail;
            dummyTail.prev = newTail;
        }

        Node getTail() {
            return dummyTail.prev;
        }
    }

    LinkedNodeList list;
    Map<Integer, Node> map;
    Integer cap;

    public LRUCache(int capacity) {
        this.list = new LinkedNodeList();
        this.map = new HashMap<>(capacity);
        this.cap = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (null == node) {
            return -1;
        } else {
            // cause it's recently called
            list.moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (null != node) {
            // update val
            node.val = value;
            list.moveToHead(node);
        } else {
            // new val
            Node newNode = new Node(key, value);
            // remove lru if it's already reached the capacity
            if (map.size() == cap) {
                Node tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }
}
