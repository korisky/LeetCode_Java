package Ex2997_MinimumNumberOpsArrayXOREqualK;

public class Solution {

    public int minOperations(int[] nums, int k) {

        // 1) 对数组内所有integer进行XOR
        int finalXor = 0;
        for (int n : nums) {
            finalXor = finalXor ^ n;
        }

        // 2) 持续循环, 直到k或者finalXor变为0
        int count = 0;
        while (k > 0 || finalXor > 0) {
            // 不相等的情况下, 进行ops更新
            if ((k % 2) != (finalXor % 2)) {
                count++;
            }
            // 除2
            k /= 2;
            finalXor /= 2;
        }

        return count;
    }
}
