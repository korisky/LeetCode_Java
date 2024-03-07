package Ex601_900.Ex767_ReorganizeString;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    static class Compact {
        char letter;
        int remain;

        public Compact(char letter, int remain) {
            this.letter = letter;
            this.remain = remain;
        }
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaabbbcdd"));
    }

    /**
     * 题目需要重排String, 达到相邻不会存在重复元素,
     * 可以使用这种方法, 先统计每个char的统计次数, 从大频率到小频率进行char的位置排放,
     * 每次对剩余位置进行填补, 同种元素隔开保存, 无法得到结果时则返回”“
     */
    public static String reorganizeString(String s) {

        // 1. 统计频率
        int[] freqArr = new int[26];
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            freqArr[c - 'a']++;
        }

        // 2. 对统计部分进行初步判断, 只要某个元素超过了总字符数的一半, 则绝对不可能完成无连续排序的情况
        int maxFreq = Integer.MIN_VALUE;
        Queue<Compact> queue = new PriorityQueue<>((a, b) -> b.remain - a.remain);
        for (int i = 0; i < freqArr.length; i++) {
            int freq = freqArr[i];
            if (freq != 0) {
                queue.add(new Compact((char) (i + 'a'), freq));
                maxFreq = Math.max(maxFreq, freq);
            }
        }
        if (maxFreq > (charArr.length + 1) / 2) {
            return "";
        }

        // 3.进行间隔填补, 优先填补最大出现次数的字符
        char[] result = new char[charArr.length];
        Arrays.fill(result, '0');

        int idx = 0;
        while (!queue.isEmpty()) {
            // 每次完全耗尽一个字符, 才到另一个
            Compact curUsing = queue.poll();
            while (curUsing.remain > 0) {
                // 超过位置, 重新开始
                if (idx > result.length - 1) {
                    idx = 0;
                    continue;
                }
                // 已经使用过, 跳过
                if (result[idx] != '0') {
                    idx++;
                    continue;
                }
                // 没有使用过, 进行间隔插入
                result[idx] = curUsing.letter;
                idx += 2;
                curUsing.remain--;
            }
        }
        return new String(result);
    }
}
