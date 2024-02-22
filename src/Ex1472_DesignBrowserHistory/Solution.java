package Ex1472_DesignBrowserHistory;

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
public class Solution {

    class BrowserHistory {

        class Node {
            Node prev;
            Node next;
            String url;

            public Node(Node prev, Node next, String url) {
                this.prev = prev;
                this.next = next;
                this.url = url;
            }
        }

        private Node curNode;

        public BrowserHistory(String homepage) {
            curNode = new Node(null, null, homepage);
        }

        public void visit(String url) {
            Node newNode = new Node(curNode, null, url);
            newNode.prev = curNode;
            curNode.next = newNode;
            curNode = newNode;
        }

        public String back(int steps) {
            while (steps-- > 0 && curNode.prev != null) {
                curNode = curNode.prev;
            }
            return curNode.url;
        }

        public String forward(int steps) {
            while (steps-- > 0 && curNode.next != null) {
                curNode = curNode.next;
            }
            return curNode.url;
        }
    }
}
