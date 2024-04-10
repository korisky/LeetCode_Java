package Ex901_1200.Ex950_RevealCardsIncreasingOrder;

import java.util.*;

public class Solution {

    /**
     * 尝试使用倒推的方式, 先进行排序, 然后从n-2开始排, 每次排的时候, 当前排好的最后一个提前到第二位
     */
    public static int[] deckRevealedIncreasing(int[] deck) {
        // 先进行排序, 尝试bottom up的方式
        Arrays.sort(deck);

        // 用list方便进行操作
        List<Integer> listArr = new LinkedList<>();
        listArr.add(deck[deck.length - 1]);

        // 从后往前遍历, 每次都进行最后一位删除, 插入到头部, 然后头部再插入最新节点
        for (int i = deck.length - 2; i >= 0; i--) {
            Integer lastOne = listArr.removeLast();
            listArr.addFirst(lastOne);
            listArr.addFirst(deck[i]);
        }
        // 使用map2int相当于又遍历了一边, 速度比下面纯pop出来的慢一个量级
        return listArr.stream().mapToInt(i -> i).toArray();
    }

    public static int[] deckRevealedIncreasing_another(int[] deck) {
        Arrays.sort(deck);
        // Deque方便进行操作
        Deque<Integer> listArr = new LinkedList<>();
        listArr.add(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--) {
            Integer lastOne = listArr.removeLast();
            listArr.addFirst(lastOne);
            listArr.addFirst(deck[i]);
        }
        int[] res = new int[deck.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = listArr.pop();
        }
        return res;
    }

    public static void main(String[] args) {

        long startTime2 = System.nanoTime();
        deckRevealedIncreasing_another(new int[]{17, 13, 11, 2, 3, 5, 7});
        long endTime2 = System.nanoTime();
        System.out.println("Func 2: used " + (endTime2 - startTime2));

        long startTime = System.nanoTime();
        deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
        long endTime = System.nanoTime();
        System.out.println("Func 1: used " + (endTime - startTime));


//        for (int i : theArr) {
//            System.out.print(i + " ");
//        }
        System.out.println();
    }
}
