package Ex215_KthLargestElementInArray;

import java.util.PriorityQueue;
import java.util.Queue;

public class AnotherSol {


    /**
     * 找到topN最大或者最小的元素, 实际上考核的是跟QuickSort很近似的QuickSelect算法, 最好用这个而不是偷工减料的Arrays.sort
     */
    public static void main(String[] args) {
        int topN = 6;
        int[] test = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};

        // quickSelect
//        int i = quickSelect(test, 0, test.length - 1, test.length - topN);
//        System.out.println("Top " + topN + ", is: " + i);

        // minHeap
        int i = minHeap(test, 2);
        System.out.println("Top " + topN + ", is: " + i);

        // quickSort
        quickSort(test, 0, test.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i1 : test) {
            sb.append(i1 + " ");
        }
        System.out.println(sb);
    }

    /**
     * 对于LeetCode的test限制, minHeap可能才是他们希望我们使用的方式
     */
    public static int minHeap(int[] nums, int topK) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > topK) {
                minHeap.poll(); // 剔除在queue后面的
            }
        }
        return minHeap.peek(); // 从小到大的排序, 找第一个是最小的, 也就是topN
    }


    /**
     * QuickSelect的不同, 由于知道需要找到top几的数而且总数是确定的, 所以可以只查找一半来接近O(nlogN)
     * 但是极端大的nums的情况下, 在LeetCode会超时
     */
    public static int quickSelect(int[] nums, int low, int high, int targetIdx) {

        // 当两端一致, 证明就是要找这个元素, 这个与QuickSort中的只处理if(left < right)不同, 相等直接可返回
        if (low == high) {
            return nums[low];
        }

        // 获取pivotIdx的partition部分完全与QuickSort一致
        int pivotIdx = partition(nums, low, high);

        // 核心不同点从这开始, 若需要找的idx正好是pivot, 立刻可以返回
        if (pivotIdx == targetIdx) {
            return nums[pivotIdx];
        }

        if (pivotIdx < targetIdx) {
            // 若当前pivot还没到idx, 证明要找比pivot更大的部分
            return quickSelect(nums, pivotIdx + 1, high, targetIdx);
        } else {
            // 若当前pivot比idx大, 则是找更小的部分
            return quickSelect(nums, low, pivotIdx - 1, targetIdx);
        }
    }

    /**
     * QuickSort, 最好O(nLogN), 最差O(n^2)的排序算法
     * 核心在于: 通过partition切分小于和大于pivot的部分, 然后再对这两个部分继续quickSort
     */
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
