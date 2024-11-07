package Ex2275_LargestCombinationWithBitwiseANDGreaterThanZero;

public class Solution {


    /**
     * 更快的方法在于, 只需要统计每个ele的bit的位置, 将其放入一个32的数组, 最后统计哪一个bit更多就可以了
     */
    public static int largestCombination_faster(int[] candidates) {
        // 1. 进行每个bit位置的统计
        int[] bitArr = new int[32];
        for (int candidate : candidates) {
            count(candidate, bitArr);
        }
        // 2. 找到统计频率最大的, 就是最大共同&又不是0的数目
        int max = 0;
        for (int cut : bitArr) {
            max = Math.max(max, cut);
        }
        return max;
    }

    private static void count(int ele, int[] bits) {
        // 从最高的bit开始, 是为了保持从左到右的自然读数顺序
        int j = 31;
        while (ele > 0) {
            // array是从右到左, 计算也是, 用最低位开始计算进行记数
            bits[j] += (ele & 1);
            // 除2 -> 向右移动1位
            ele >>= 1;
            j--;
        }
    }


    /**
     * 题目希望尽可能的使用更多的元素进行&操作, 并且得到的结果可以是>0
     */
    public static int largestCombination(int[] candidates) {

        // 尝试使用bit比对方法, 从最低bit开始进行确认&之后的结果, 直到当前位1的数目 <= 1 停止
        int bitPosition = 0;
        int maxVal = 0;
        int maxComp = 0;
        int maxBitPos = 0;
        boolean first = true;

        while (true) {
            // and
            int oneCount = 0;
            int mask = 1 << bitPosition++;
            for (int candidate : candidates) {
                // mask for bit
                int curNumBit = candidate & mask;
                if (curNumBit != 0) {
                    oneCount++;
                }
                // find the largest on the same way, only for first iteration
                if (first) {
                    maxVal = Math.max(maxVal, candidate);
                }
            }
            // only for one iteration
            if (first) {
                maxBitPos = Integer.SIZE - Integer.numberOfLeadingZeros(maxVal);
                first = false;
            }
            // update
            maxComp = Math.max(maxComp, oneCount);
            // break
            if (bitPosition > maxBitPos) {
                break;
            }
        }
        return maxComp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{16, 17, 71, 62, 12, 24, 14};
//        int[] arr = new int[]{8, 8};
        System.out.println(largestCombination(arr));
    }
}
