package Ex1_300.Ex211_to_240.Ex215_KthLargestElementInArray;

public class SolutionCountingSorting {

    /**
     * 不使用PriorityQueue或者QuickSort的情况下, 可以使用CountSort
     */
    public int findKthLargest(int[] nums, int k) {

        // 找到最大最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // 缩减范围, 进行频率确认
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        // 从高频次到低频次, 如果到达或者超出了topK, 那么就返回那一个值即可
        int remain = k;
        for (int idx = count.length - 1; idx >= 0; idx--) {
            remain -= count[idx];
            if (remain <= 0) {
                return idx + min;
            }
        }
        return -1;
    }

}
