package Ex1_300.Ex121_to_150.Ex127_WordLadderII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Description:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 * <p>
 * 需要使用BFS进行所有Branch的搜索, 但如果使用双向BFS速度会快很多, 重点在于, 每次进行BFS, 都从下一层更少node的开始进行扩展
 */
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = 1;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> forwardSet = new HashSet<>();
        HashSet<String> backwardSet = new HashSet<>();
        HashSet<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) {
            return 0;
        }
        wordDict.remove(endWord);
        wordDict.remove(beginWord);

        forwardSet.add(beginWord);
        backwardSet.add(endWord);
        while (!forwardSet.isEmpty() && !backwardSet.isEmpty()) {
            // each time, expand the one with less possible nodes
            if (forwardSet.size() > backwardSet.size()) {
                HashSet<String> temp = forwardSet;
                forwardSet = backwardSet;
                backwardSet = temp;
            }
            // try find all next level's words
            HashSet<String> nextLevel = new HashSet<>();
            for (String word : forwardSet) {
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordChars.length; i++) {
                    for (char replaceChar = 'a'; replaceChar <= 'z'; replaceChar++) {
                        // try to replace the single char
                        char last = wordChars[i];
                        wordChars[i] = replaceChar;
                        String tempWord = String.valueOf(wordChars);
                        // if already visited
                        if (backwardSet.contains(tempWord)) {
                            return len + 1;
                        }
                        // if it's a legal change, and not visited yet
                        if (!visited.contains(tempWord) && wordDict.contains(tempWord)) {
                            visited.add(tempWord);
                            nextLevel.add(tempWord);
                        }
                        // replace back to that char
                        wordChars[i] = last;
                    }
                }
            }
            // replace the next to forward
            forwardSet = nextLevel;
            len++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> test = new ArrayList<>();
        test.add("ymann");
        test.add("yycrj");
        test.add("oecij");
        test.add("ymcnj");
        test.add("yzcrj");
        test.add("yycij");
        test.add("xecij");
        test.add("yecij");
        test.add("ymanj");
        test.add("yzcnj");
        test.add("ymain");

        System.out.println(s.ladderLength("ymain", "oecij", test));
    }

}
