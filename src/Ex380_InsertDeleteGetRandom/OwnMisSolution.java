package Ex380_InsertDeleteGetRandom;

import java.util.HashSet;

/**
 * 组建一个轮询的randomSet
 */
public class OwnMisSolution {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.getRandom());
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }


    static class RandomizedSet {

        HashSet<Integer> valSet;

        Node dumHead;

        Node cur;

        public RandomizedSet() {
            valSet = new HashSet<>();
            dumHead = new Node(0);
        }

        public boolean insert(int val) {
            if (valSet.contains(val)) {
                return false;
            }
            valSet.add(val);
            // node list
            Node iter = dumHead;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = new Node(val);
            return true;
        }

        public boolean remove(int val) {
            if (!valSet.contains(val)) {
                return false;
            }
            valSet.remove(val);
            Node iter = dumHead;
            while (iter.next != null) {
                if (iter.next.val == val) {
                    iter.next = iter.next.next;
                    break;
                }
                iter = iter.next;
            }
            return true;
        }

        public int getRandom() {
            if (cur == null) {
                cur = dumHead.next;
            }
            Node nxt = cur;
            cur = cur.next;
            return nxt.val;
        }
    }
}
