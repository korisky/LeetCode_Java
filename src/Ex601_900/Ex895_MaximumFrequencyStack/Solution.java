package Ex601_900.Ex895_MaximumFrequencyStack;

import java.util.*;

/**
 * 个人的PriorityQueue + FreqMap的方式, 可惜TLE超过时长
 */
public class Solution {

    static class Node {
        int num;
        Node prev;
        Node next;

        public Node(int num) {
            this.num = num;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    static class Compact {
        int num;

        int freq;

        public Compact(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }


    static class FreqStack {

        private Map<Integer, Integer> freqMap;
        private Queue<Compact> priQueue;
        private Node dumTail;


        public FreqStack() {
            // 统计使用
            this.freqMap = new HashMap<>();
            this.priQueue = new PriorityQueue<>((a, b) -> b.freq - a.freq);
            // 保存具体元素的LinkedList (仅保留尾部指针)
            this.dumTail = new Node(0);
        }

        public void push(int val) {

            // 1) 在Map中找到并更新统计频率
            int freq = freqMap.getOrDefault(val, 0) + 1;
            freqMap.put(val, freq);

            // 2) 插入PriorityQueue中
            priQueue.add(new Compact(val, freq));

            // 3) 保存数据, 添加到双向链表尾部
            Node newNode = new Node(val);
            if (dumTail.prev == null) {
                // 第一个节点插入
                dumTail.prev = newNode;
                newNode.next = dumTail;
            } else {
                // 已经有存量节点
                dumTail.prev.next = newNode;
                newNode.prev = dumTail.prev;
                dumTail.prev = newNode;
                newNode.next = dumTail;
            }
        }

        // 题目规定, 一定有元素才pop, 暂时不处理conner-case
        public int pop() {
            // 1) 从PriorityQueue中持续Pop相同频率的元素
            Set<Integer> sameFreqSet = new HashSet<>();
            List<Compact> remainList = new LinkedList<>();

            // 弹出值, 添加到set和list中
            Compact ele = priQueue.poll();
            sameFreqSet.add(ele.num);
            remainList.add(ele);

            // pop 相同频率的元素
            while (!priQueue.isEmpty() && priQueue.peek().freq == ele.freq) {
                Compact theEle = priQueue.poll();
                sameFreqSet.add(theEle.num);
                remainList.add(theEle);
            }

            // 2) 反向查找, 从tail指针找到第一个存在set中的元素
            Node cur = dumTail;
            int numFound = 0;
            while (cur.prev != null) {
                // 找到第一个存在同频率的num
                if (sameFreqSet.contains(cur.prev.num)) {

                    // 2.1) 链表断开
                    Node node = cur.prev;
                    numFound = node.num;
                    if (node.prev != null) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                    } else {
                        node.next.prev = null;
                    }

                    // 2.2) 缩减freqMap对应元素的freq (0则remove)
                    int freq = freqMap.get(node.num) - 1;
                    if (freq == 0) {
                        freqMap.remove(node.num);
                    } else {
                        freqMap.put(node.num, freq);
                    }

                    // 2.3) list中删除pop出来的元素, 剩余的重新添加回queue中
                    Compact theCompact = remainList.stream()
                            .filter(compact -> compact.num == node.num)
                            .findAny()
                            .get();
                    remainList.remove(theCompact);
                    priQueue.addAll(remainList);
                    break;
                }
                // 继续向前
                cur = cur.prev;
            }

            return numFound;
        }
    }

    public static void main(String[] args) {

        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

}
