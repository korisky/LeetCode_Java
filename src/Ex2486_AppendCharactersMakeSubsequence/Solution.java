package Ex2486_AppendCharactersMakeSubsequence;

public class Solution {

    /**
     * 问题的难点在于, 实际上使用Greedy能确保一定找到的就是最少的
     */
    public int appendCharacters(String s, String t) {
        int j = 0, n = s.length(), m = t.length();
        for (int i = 0; i < n && j < m; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        // 需要额外的操作, 就是剩余的部分
        return m - j;
    }
}
