package Ex3042_CountPrefixAndSuffixPairsI;

public class Solution {


    class Node {
        private Node[] links = new Node[26];

        public boolean contains(char c) {
            return links[c - 'a'] != null;
        }

        public void put(char c, Node node) {
            links[c - 'a'] = node;
        }

        public Node next(char c) {
            return links[c - 'a'];
        }
    }

    class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (char c : word.toCharArray()) {
                if (!node.contains(c)) {
                    node.put(c, new Node());
                }
                node = node.next(c);
            }
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.contains(c)) {
                    return false;
                }
                node = node.next(c);
            }
            return true;
        }
    }


    public int countPrefixSuffixPairs(String[] words) {

        int n = words.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            Trie prefixTrie = new Trie();
            Trie suffixTrie = new Trie();

            prefixTrie.insert(words[i]);

            String revWord = new StringBuilder(words[i])
                    .reverse().toString();
            suffixTrie.insert(revWord);

            for (int j = 0; j < i; j++) {
                if (words[j].length() > words[i].length()) {
                    continue;
                }

                String prefixWord = words[j];
                String revPrefixWord = new StringBuilder(prefixWord)
                        .reverse().toString();

                if (prefixTrie.startsWith(prefixWord) && suffixTrie.startsWith(revPrefixWord)) {
                    count++;
                }
            }
        }
        return count;
    }
}
