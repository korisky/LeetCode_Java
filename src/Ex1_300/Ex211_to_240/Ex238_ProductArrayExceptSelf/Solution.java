package Ex1_300.Ex211_to_240.Ex238_ProductArrayExceptSelf;

import java.util.Arrays;

public class Solution {

    /**
     * 需要考虑拆解, 从0开始到i-1相乘, 从n开始到i+1相乘, 这样两个数据再进行想乘,
     * 得到的就是除去i自身的剩余其他所有元素乘法数组
     */
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);

        // 正向进行乘法, 先乘curr然后再更新
        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        // 反向进行想乘法, 先乘curr然后再更新
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
