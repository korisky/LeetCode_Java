package Ex601_900.Ex895_MaximumFrequencyStack;

import java.util.HashMap;
import java.util.Stack;

public class FasterSolution {
    class FreqStack {

        HashMap<Integer, Integer> freqMap;
        HashMap<Integer, Stack<Integer>> mStack;

        int maxFreq = 0;

        public FreqStack() {
            this.freqMap = new HashMap<>();
            this.mStack = new HashMap<>();
        }

        public void push(int val) {
            // 更新频率统计Map
            int f = freqMap.getOrDefault(val, 0) + 1;
            freqMap.put(val, f);
            maxFreq = Math.max(maxFreq, f);

            // 更新频率stackMap, 针对该频次, 将Num填入进去
            if (!mStack.containsKey(f)) {
                mStack.put(f, new Stack<>());
            }
            mStack.get(f).add(val);
        }

        public int pop() {
            // 1) 从最高频次获取, 再加上Stack的先进后出, 所以一定是靠后进入的值先获取得到 (不用考虑同频次需要添回PriorityQueue这种做法)
            Stack<Integer> stack = mStack.get(maxFreq);
            Integer val = stack.pop();
            if (maxFreq == 1) {
                // 避免内存泄漏
                freqMap.remove(val);
            } else {
                // 降低频次
                freqMap.put(val, maxFreq - 1);
            }
            // 2) 判断是否需要更新maxFreq (该频次下的stack为空)
            if (stack.isEmpty()) {
                mStack.remove(maxFreq--);
            }
            return val;
        }

    }
}
