package Ex301_600.Ex571_to_600.Ex599_MaximumDepthOfNaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int depth = 0;
        Queue<Node> theQueue = new LinkedList<>();
        theQueue.offer(root);
        while (!theQueue.isEmpty()) {
            int curLevelNum = theQueue.size();
            for (int i = 0; i < curLevelNum; i++) {
                List<Node> list = theQueue.poll().children;
                for (Node n : list) {
                    if (n.children != null)
                        theQueue.offer(n);
                }
            }
            depth++;
        }
        return depth;
    }
}
