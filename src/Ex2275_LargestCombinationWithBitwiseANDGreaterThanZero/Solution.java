package Ex2275_LargestCombinationWithBitwiseANDGreaterThanZero;

public class Solution {

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
