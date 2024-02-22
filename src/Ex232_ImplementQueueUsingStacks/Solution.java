package Ex232_ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class Solution {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.peek();
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }


    /***
     * 题目要求使用2个Stack来实现Queue的特性，也就是FILO组成FIFO,
     * 实际上我们可以分2段, 一段input专门负责push进来, 一段output专门负责pop, 当output为空则重新从input获取即可
     */
    static class MyQueue {

        private Stack<Integer> input = new Stack<>();
        private Stack<Integer> output = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if (output.empty()) {
                while (!input.empty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.empty() && output.empty();
        }
    }
}
