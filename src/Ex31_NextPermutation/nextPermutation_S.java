package Ex31_NextPermutation;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;

public class nextPermutation_S {
    public void nextPermutation(int[] nums) {

        // 1. we need to locate where it violate 'DECREASING'
        int peekLeft = nums.length - 2;
        while (peekLeft >= 0 && nums[peekLeft] >= nums[peekLeft + 1]) {
            peekLeft--;
        }
        if (peekLeft < 0) {
            // if it does not violate the 'DECREASING', we just reverse it;
            reverse(nums, 0);
            return;
        }

        // 2. we need to figure out the smallest ele in the "DECREASING" sequence
        int peekRight = peekLeft + 1;
        for (int j = peekLeft + 1; j < nums.length; j++) {
            // we might miss this situation: 8,15,10,9,6,4
            // here if we just switch 8 and 15 would be wrong, we need to switch 8 and 9
            if (nums[j] > nums[peekLeft] && nums[j] <= nums[peekRight])
                peekRight = j;
        }

        // 3. after we find out the CORRECT eles for swapping
        int temp = nums[peekRight];
        nums[peekRight] = nums[peekLeft];
        nums[peekLeft] = temp;
        // 4. we need to swap lowest eles to the tail
        reverse(nums, peekLeft + 1);
    }

    //program to reverse index from certain index "pos"
    public void reverse(int[] nums, int pos) {
        if (pos == 0) {
            // reverse the whole array
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        } else {
            int i = pos, j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        nextPermutation_S use = new nextPermutation_S();
        int[] test = new int[]{3, 8, 15, 10, 6, 5, 3, 2, 1};
        use.nextPermutation(test);
        for (int i : test)
            System.out.println(i);
    }

}
