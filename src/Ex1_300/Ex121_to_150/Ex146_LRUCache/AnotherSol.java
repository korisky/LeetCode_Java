package Ex1_300.Ex121_to_150.Ex146_LRUCache;

import java.util.HashMap;
import java.util.Map;

public class AnotherSol {

    public static void main(String[] args) {
        AnotherSol anotherSol = new AnotherSol(2);
        anotherSol.put(1, 1);
        anotherSol.put(2, 2);
        System.out.println(anotherSol.get(1));
        anotherSol.put(3, 3);
        System.out.println(anotherSol.get(2));
        anotherSol.put(4, 4);
        System.out.println(anotherSol.get(1));
        System.out.println(anotherSol.get(3));
        System.out.println(anotherSol.get(4));
    }

    static class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    int num = 0;
    int capacity;
    Map<Integer, Integer> map;


    public AnotherSol(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    /**
     * 记住LRU最近使用, 这个使用不仅是PUT, 还包含GET
     */
    public int get(int key) {
        Integer result = map.getOrDefault(key, -1);
        if (result != -1) {
            Node node = cutByKey(key);
            addHead(node);
        }
        return result;
    }

    public void put(int key, int value) {

        // contains
        if (map.containsKey(key)) {
            // cut by key
            Node thatNode = cutByKey(key);
            // add to head
            addHead(thatNode);
        }

        // not contains
        if (!map.containsKey(key)) {
            // add to head
            num++;
            addHead(new Node(key, value));
            map.put(key, value);
            // check capacity
            if (num > capacity) {
                exceedRemove();
            }
        }
    }

    private void addHead(Node node) {
        node.next = head;
        head = node;
    }

    private void exceedRemove() {
        int idx = 0;
        Node newTail = head;
        while (idx++ < capacity - 1) {
            newTail = newTail.next;
        }
        Node oldTail = newTail.next;
        newTail.next = null;
        map.remove(oldTail.key);
        num--;
    }

    private Node cutByKey(int key) {
        Node cur = head;
        if (cur.val == key) {
            head = head.next;
            return cur;
        }
        while (cur.next != null) {
            if (cur.next.val != key) {
                cur = cur.next;
            } else {
                // found
                Node tmp = cur.next;
                cur.next = cur.next.next;
                return tmp;
            }
        }
        return cur;
    }
}
