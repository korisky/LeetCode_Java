package Ex1915_NumberWonderfulSubstrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 题目需要寻找wonderful字符串, 要求是至多只有1个字符出现的频率是奇数(或者没有任何字符是奇数), 其他全部是偶数
     */
    public long wonderfulSubstrings_Optimization(String word) {

        int N = word.length();

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int mask = 0;
        long res = 0L;
        for (int i = 0; i < N; i++) {
            char c = word.charAt(i);
            int bit = c - 'a';

            mask ^= (1 << bit);
            res += freq.getOrDefault(mask, 0);
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);

            for (int odd_c = 0; odd_c < 10; odd_c++) {
                res += freq.getOrDefault(mask ^ (1 << odd_c), 0);
            }
        }


        return res;
    }
}
