package Ex1_300.Ex121_to_150.Ex139_WordBreak;

import java.util.ArrayList;
import java.util.List;

/**
 * Dfs 方式进行搜索, 但是速度过慢
 */
public class DfsSolution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfsBacktracking(s, 0, wordDict);
    }

    public boolean dfsBacktracking(String s, int curIndex, List<String> wordDict) {
        if (curIndex == s.length()) {
            return true;
        }
        String curSubString = s.substring(curIndex);
        for (String dict : wordDict) {
            if (curSubString.startsWith(dict)
                    && dfsBacktracking(s, curIndex + dict.length(), wordDict)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DfsSolution test = new DfsSolution();
        String str1 = "leetcode";
        String str2 = "lee";
        String str3 = "code";
        String str4 = "leet";
        List<String> list = new ArrayList<>();
        list.add(str2);
        list.add(str3);
        list.add(str4);
        System.out.println(test.wordBreak(str1, list));
    }
}
