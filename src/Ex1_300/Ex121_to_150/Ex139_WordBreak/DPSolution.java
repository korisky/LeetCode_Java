package Ex1_300.Ex121_to_150.Ex139_WordBreak;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划方式, 因为内部其实有很多重复的问题
 * 使用两个指针, 一个数组. 数组的长度是s+1, 因为第一个作为空字符串
 * 其中大指针从左到右进行扫描, 而小指针则是在此基础上, 重复从左到右搜索
 * 每次数组记录的就是, 从0到那个位置, 是不是能找得到dict中内容
 */
public class DPSolution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int strLen = s.length();
        boolean[] dp = new boolean[strLen + 1];
        dp[0] = true;
        // small improvement
        int wordMaxLen = 0;
        for (String word : wordDict) {
            wordMaxLen = Math.max(wordMaxLen, word.length());
        }
        // extend and shrink, keep recording the slot
        for (int i = 1; i < strLen + 1; i++) {
            for (int j = 0; j < i; j++) {
                // in the shrink stage, if the length already greater than the max one, keep shrink it first
                if (i - j > wordMaxLen) {
                    continue;
                }
                // try finding
                String subStr = s.substring(j, i);
                if (dp[j] && wordDict.contains(subStr)) {
                    // let i become true
                    dp[i] = true;
                    break;
                }
            }
        }
        return  dp[strLen];
    }



    public static void main(String[] args) {
        DPSolution test = new DPSolution();
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
