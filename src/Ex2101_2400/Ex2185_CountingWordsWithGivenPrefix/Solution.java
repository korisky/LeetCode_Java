package Ex2101_2400.Ex2185_CountingWordsWithGivenPrefix;

public class Solution {

    class Trie {

        Node root;

        Trie() {
            root = new Node();
        }


        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.links[c - 'a'] == null) {
                    cur.links[c - 'a'] = new Node();
                }
                cur = cur.links[c - 'a']; // 添加到头部
                cur.count++; // 证明自己前面已经有多少节点(深度)
            }
        }

        public int countPrefix(String pref) {
            Node cur = root;
            for (int i = 0; i < pref.length(); i++) {
                char c = pref.charAt(i);
                if (cur.links[c - 'a'] == null) {
                    return 0;
                }
                cur = cur.links[c - 'a'];
            }
            return cur.count;
        }
    }

    class Node {

        Node[] links;

        int count;

        Node() {
            links = new Node[26];
            count = 0;
        }
    }

    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        return trie.countPrefix(pref);
    }


}
