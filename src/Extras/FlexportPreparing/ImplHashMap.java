package Extras.FlexportPreparing;


/**
 * Only support String,String
 * Not considering resize the table
 */
public class ImplHashMap {

    /**
     * HashNode could become a list
     */
    class HashNode {
        String key;
        String val;
        HashNode next;

        public HashNode(String key, String val) {
            this.key = key;
            this.val = val;
        }

        public HashNode(String key, String val, HashNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public HashNode getNext() {
            return next;
        }

        public void setNext(HashNode next) {
            this.next = next;
        }
    }

    /**
     * Table contains HashNodes
     */
    private HashNode[] table;

    public ImplHashMap(int bucketsNum) {
        this.table = new HashNode[bucketsNum];
    }

    // A. put a val (update if same val)
    public HashNode put(String key, String val) {

        HashNode result;

        // 1. get the hash of key and find the slot
        int curBucket = (key.hashCode() % this.table.length);

        // 2. find if there is a val
        HashNode pre = table[curBucket];
        HashNode hashNode = pre.next;

        // 3. add / update node
        if (pre.val == val) {
            pre.next = new HashNode(key,val);
            result = pre.next;
        } else {
            // into a loop
            while (hashNode != null) {
                if (hashNode.val == val) {
                    break;
                }
                hashNode = hashNode.next;
                pre = pre.next;
            }
            // add a new node, or update it
            if (hashNode == null) {
                pre.next = new HashNode(key, val);
                result = pre.next;
            } else {
                hashNode.setVal(val);
                result = hashNode;
            }
        }
        return result;
    }



    // B. get a val (null if not contains)



}
