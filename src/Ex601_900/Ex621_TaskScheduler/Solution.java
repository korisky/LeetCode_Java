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
        // 这里的意思是, 最大频次是两端, 其中间有freq-1个间隙, 所以这里是freq-1, 并且停顿时间是n
        int idleTime = (maxFreq - 1) * n;

        // 3. 尽可能的缩减idleTime, 通过其他task进行填补, 从高频次到低频次
        for (int i = 24; i >= 0; i--) {
            // 这里的min是指填:
            // 1) 如果freq[i]跟freq[25]相同, 那么这里也并不能减去freq[25]这么多个频次, 只能取每一个间隙, 也就是maxFreq - 1
            // 2) 如果freq[i]比间隙少, 那就只能减去那么多, 用不满每一个间隙
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
