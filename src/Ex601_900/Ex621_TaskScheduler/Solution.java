package Ex601_900.Ex621_TaskScheduler;

import java.util.Arrays;

public class Solution {


    /**
     * GPT 提供的方法, 考虑将总次数划分为, task的长度 + idleTime等待时间, 即总时长
     */
    public static int leastInterval(char[] tasks, int n) {

        // 1. 统计出现频次
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // 2. 排序确认最高频次的task
        // 最多停顿的次数, 一定是某个task出现的频次-1 乘 要等待的n（第一次不需要等待所以-1）
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleTime = (maxFreq - 1) * n;

        // 3. 尽可能的缩减idleTime, 通过其他task进行填补, 从高频次到低频次
        for (int i = 24; i >= 0; i--) {
            // 这里的min是指, 如果任务频次相同则直接减去中间所有的空位, 如果不是, 那么根据频次进行填补
            idleTime -= Math.min(maxFreq - 1, freq[i]);
        }
        return tasks.length + Math.max(0, idleTime);
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'};
//        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks, 2));
    }
}
