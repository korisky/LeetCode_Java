package Ex429_N_aryTreeLevelOrderTraversal;

import java.util.*;

public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> theQueue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null)
            theQueue.offer(root);

        while (!theQueue.isEmpty()) {
            int curLevelNodeNum = theQueue.size();
            List<Integer> curLevelNodes = new ArrayList<>();
            for (int i = 0; i < curLevelNodeNum; i++) {
                Node cur = theQueue.poll();
                for (Node n : cur.children)
                    theQueue.offer(n);
                curLevelNodes.add(cur.val);
            }
            res.add(curLevelNodes);
        }
        return res;
    }
}
