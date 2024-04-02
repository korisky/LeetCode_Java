package Ex1_300.Ex181_to_210.Ex205_IsomorphicStrings;

import java.util.Arrays;

public class Solution {

    /**
     * 判断两个字符串, 通过映射的方式, 是否可以映射成另一个 (ASCII码可以用256直接存)
     * 能比较简单的想到, 使用一个类似frequencyArr的进行记录, 但这里是记录是否被替换过
     * 另外还要考虑 babc -> badc这种情况, 所以比较简单的做法是同时维持2个array, 记录s->t和t->s的映射
     *
     * 核心在于: 对于s->t和t->s来说, 一定是要么该字符两边都还没有映射, 要么都是映射成功, 只要不符合都是false
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] s2tMapping = new int[256];
        int[] t2sMapping = new int[256];
        Arrays.fill(s2tMapping, -1);
        Arrays.fill(t2sMapping, -1);

        for (int idx = 0; idx < s.length(); idx++) {
            char sChar = s.charAt(idx);
            char tChar = t.charAt(idx);
            if (s2tMapping[sChar] < 0 && t2sMapping[tChar] < 0) {
                // 初始化, 两侧都进行映射填补
                s2tMapping[sChar] = tChar;
                t2sMapping[tChar] = sChar;
            } else if (s2tMapping[sChar] != tChar || t2sMapping[tChar] != sChar) {
                // 只要从s->t或t->s有一个映射不对, 那么就一定不可能映射成功
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isIsomorphic("egg", "add"));
//        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("baba", "badc"));
    }
}
