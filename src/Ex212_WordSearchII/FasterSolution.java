package Ex212_WordSearchII;

import java.util.ArrayList;
import java.util.List;

public class FasterSolution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // a - z
        String word;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode traverse = root;
            for (char c : word.toCharArray()) {
                if (traverse.children[c - 'a'] == null)
                    traverse.children[c - 'a'] = new TrieNode();
                traverse = traverse.children[c - 'a'];
            }
            traverse.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsFindWords(board, i, j, root, results);
            }
        }
        return results;
    }

    public void dfsFindWords(char[][] board, int row, int col, TrieNode curNode, List<String> results) {
        char curChar = board[row][col];
        if (curChar == '#' || curNode.children[curChar - 'a'] == null)
            // if we recurrently use this char, or this char is not even a prefix for any word
            return;
        curNode = curNode.children[curChar - 'a'];
        // can be consider as: if we add this char, would it be a full word?
        if (curNode.word != null) {
            results.add(curNode.word);
            curNode.word = null; // we can reduce duplicated stuff by removing them after searched once
        }
        // if it's null, means we are at some 'prefix' value, we need to keep finding
        board[row][col] = '#';
        if (row - 1 >= 0)
            dfsFindWords(board, row - 1, col, curNode, results); // up
        if (row + 1 < board.length)
            dfsFindWords(board, row + 1, col, curNode, results); // down
        if (col - 1 >= 0)
            dfsFindWords(board, row, col - 1, curNode, results); // left
        if (col + 1 < board[0].length)
            dfsFindWords(board, row, col + 1, curNode, results); // right
        board[row][col] = curChar;
    }
}
