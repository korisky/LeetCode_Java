package Ex601_900.Ex826_MostProfitAssigningWork;

import java.util.TreeMap;

public class Solution {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //  初始化TreeMap
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);

        // 这里的意思是, 针对同样difficulty的作为一层, 这一层里面我们只记录最大profit的
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i],
                    Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }

        // 第二次遍历, 这里关键点是我们从keySet遍历, 也就是从difficulty低向高遍历
        // 这样更新TreeMap可以达到, 如果某个更低difficulty的任务profit更高, 更新过后高difficulty也同样用这个profit
        int best = 0, res = 0;
        for (Integer key : map.keySet()) {
            best = Math.max(map.get(key), best);
            map.put(key, best);
        }

        // 通过第二次遍历的更新后, 就可以毫不犹豫的让每个worker选择它能做到的最高的difficulty的任务
        // 这里再次使用TreeMap的特性, floorEntry, 可以是的worker拿到 <= 自己difficulty的任务
        for (int i = 0; i < worker.length; i++) {
            res += map.floorEntry(worker[i]).getValue();
        }
        return res;
    }
}
