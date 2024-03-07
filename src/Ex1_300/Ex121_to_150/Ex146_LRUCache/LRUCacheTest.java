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

    class LRUNode {
        LRUNode prev;
        LRUNode next;
        Integer key;
        Integer val;

        public LRUNode(Integer key, Integer val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    class LRUList {

        LRUNode preHead;
        LRUNode postTail;

        public LRUList() {
            LRUNode preHead = new LRUNode(0, 0);
            LRUNode postTail = new LRUNode(0, 0);
            preHead.next = postTail;
            postTail.prev = preHead;
        }

        public void moveToHead(LRUNode node) {
            // remove from old list
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // add to head
            addToHead(node);
        }

        public void addToHead(LRUNode node) {
            LRUNode tmp = preHead.next;
            preHead.next = node;
            node.prev = preHead;
            node.next = tmp;
            tmp.prev = node;
        }

        public void removeTail() {
            LRUNode newTail = postTail.prev.prev;
            postTail.prev = newTail;
            newTail.next = postTail;
        }

    }


    private HashMap<Integer, LRUNode> map;
    private LRUList list;
    private Integer capacity;

    public LRUCacheTest(Integer capacity) {
        this.map = new HashMap<>();
        this.list = new LRUList();
        this.capacity = capacity;
    }

    public Integer get(Integer key) {
        LRUNode node = map.get(key);
        if (null == node) {
            return -1;
        }
        // move to head
        list.moveToHead(node);
        return node.val;
    }

    public void set(Integer key, Integer val) {

        LRUNode node = map.get(key);
        if (null != node) {
            // update
            node.val = val;
            list.moveToHead(node);
        } else {
            // new node
            LRUNode newNode = new LRUNode(key, val);
            if (map.size() == capacity) {
                // removeTail
                list.removeTail();
            }
            // addToHead
            list.addToHead(newNode);
            // put into Map
            map.put(key, newNode);
        }
    }


}
