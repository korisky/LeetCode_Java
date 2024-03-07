package Ex1_300.Ex151_to_180.Ex155_MinStack;

/**
 * 要点:
 *  1. 因为是让你实现Stack, 所以不应该使用Stack结构, 而是应该用更简单的结构来实现
 *  2. 需要考虑, 由于需要存放最小值, 需要考虑是不是每次都要进行比较
 */
public class MinStack {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    class Node {
        int val;
        // 重点内容, 由于stack的特殊性, 如果一个stack在push的时候push了新的最小值, 我们也仅需要
        // 在新的值上面的min设置它自己即可, 而当它pop出去的时候, 没有了这个值, 所以只需要保持即可, 不需要改变
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }


    private Node head;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

}
