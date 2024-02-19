package Ex215_KthLargestElementInArray;

public class AnotherSol {


    /**
     * 找到topN最大或者最小的元素, 实际上考核的是跟QuickSort很近似的QuickSelect算法, 最好用这个而不是偷工减料的Arrays.sort
     */
    public int findKthLargest(int[] nums, int k) {

        return 0;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        quickSort(test, 0, test.length - 1);
        System.out.println();
    }


    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            // 与MergeSort类似, 这个位置的左边和右边，分别是比该idx值更小和更大的部分
            // 但不同点是, 这些部分没有排序
            int pivotIdx = partition(nums, low, high);
            // 与MergeSort不同, 这里的idx是要跳开pivot的idx的, 因为pivot相当于已经排好了
            quickSort(nums, low, pivotIdx - 1);
            quickSort(nums, pivotIdx + 1, high);
        }
    }


    public static int partition(int[] nums, int low, int high) {
        // pivot 通常用最后一个元素
        int pivotVal = nums[high];
        // minEleIdx是用来记录最小元素的最大idx
        int minEleIdx = low - 1;
        for (int curIdx = low; curIdx < high; curIdx++) {
            if (nums[curIdx] <= pivotVal) {
                // 需要swap到前面去
                swap(nums, ++minEleIdx, curIdx);
            }
        }
        // 全部swap完, 将pivot swap到分隔的地方
        swap(nums, ++minEleIdx, high);
        return minEleIdx;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
