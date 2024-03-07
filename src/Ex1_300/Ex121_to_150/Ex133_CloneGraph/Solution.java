package Ex1_300.Ex121_to_150.Ex133_CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        return dfsHelper(node, new HashMap<>());
    }

    private Node dfsHelper(Node cur, Map<Node, Node> visited) {
        if (cur == null) {
            return null;
        }
        if (visited.containsKey(cur)) {
            return visited.get(cur);
        }
        Node newNode = new Node(cur.val);
        visited.put(cur, newNode);
        for (Node neighbor : cur.neighbors) {
            newNode.neighbors.add(dfsHelper(neighbor, visited));
        }
        return newNode;
    }
}
