package Ex179_LargestNumber;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {


    public String largestNumber(int[] nums) {

        if (null == nums || nums.length == 0) {
            return "";
        }

        // 存储 0-9, 每个slot是一个list
        PriorityQueue<Integer>[] array = new PriorityQueue[10];
        for (int wholeNum : nums) {
            // 只对第一个字符进行取模
            String str = String.valueOf(wholeNum);
            int firstNum = Integer.parseInt(str.substring(0, 1));
            for (int i = 9; i >= 0; i--) {
                if (firstNum % i == 0) {
                    addIntoQueue(array, i, wholeNum);
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        // 把所有数取完
        // 从9 -> 0, 取数字
        for (int i = 9; i >= 0; i--) {
            PriorityQueue<Integer> curSlot = array[i];
            // a. 没有数字的可以直接跳过
            if (null == curSlot) {
                continue;
            }
            // b. 只有一个数字也可以简单的添加
            if (1 == curSlot.size()) {
                result.append(curSlot.peek());
                continue;
            }
            // c. 多个数字的情况
            while (!curSlot.isEmpty()) {
                // 判断最大的数字的第二位, 是否大于该slot原本位
                Integer peek = curSlot.peek();
                String str = String.valueOf(peek);
                int numSecond = Integer.parseInt(str.substring(1, 2));
                if (numSecond > i) {
                    result.append(curSlot.poll());
                } else {

                }
            }
        }


        return null;
    }

    private void addIntoQueue(PriorityQueue<Integer>[] array, int slotIdx, int wholeNum) {
//        PriorityQueue<Integer> thisSlot = array[slotIdx - 1];
//        if (null == thisSlot) {
//            // queue is empty and not initialized
//            thisSlot = new PriorityQueue();
//            thisSlot.addFirst(wholeNum);
//        } else {
//            // keep it like priority queue with biggest one in the head
//            Integer first = thisSlot.getFirst();
//        }
    }
}
