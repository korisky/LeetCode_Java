package Ex1801_2100.Ex1823_FindWinnerOfCircularGame;

public class Solution {

    public class Node {
        Node pre;
        Node next;
        int val;

        public Node(Node pre, Node next, int val) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }
    }

    /**
     * 使用取模的方法
     */
    public int findTheWinner_Modular(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        return ans + 1;
    }


    /**
     * 尝试使用模拟的方式, 借助链表
     */
    public int findTheWinner_Simulation(int n, int k) {
        if (n == 1) {
            return 1;
        }
        // 初始化双向链表 (单独抽离头节点)
        Node head = new Node(null, null, 1);
        Node cur = head;
        for (int i = 2; i <= n; i++) {
            Node node = new Node(cur, null, i);
            cur.next = node;
            cur = node;
        }
        cur.next = head;
        head.pre = cur;
        // 模拟操作
        cur = head;
        while (n > 1) {
            for (int i = 1; i < k; i++) {
                cur = cur.next;
            }
            // 删除
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            cur = cur.next;
            n--;
        }
        return cur.val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.findTheWinner_Simulation(3, 1));
        System.out.println(s.findTheWinner_Simulation(5, 2));
    }
}
