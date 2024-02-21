package Ex225_ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class Solution {

    /**
     * 需要使用Queue实现栈的功能
     */
    class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * 重点在于push方法, 由于原始Queue中都是FIFO的方式
         * 如果希望使用Queue来实现Stack, 可以考虑再此着手, 使用rotate的方式, 让先进入的变为最先被提出的, 而前面在队伍中的到后面排队
         */
        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
