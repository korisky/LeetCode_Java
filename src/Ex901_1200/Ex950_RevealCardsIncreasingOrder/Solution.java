package Ex901_1200.Ex950_RevealCardsIncreasingOrder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        return listArr.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] theArr = deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
        for (int i : theArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
