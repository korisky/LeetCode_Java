package Ex2101_2400.Ex2206_DivideArrayIntoEqualPairs;

public class Solution {

    public static boolean divideArray(int[] nums) {
        int odd = 0;
        int[] freqArr = new int[501];
        for (int num : nums) {
            if (freqArr[num] % 2 == 0) {
                odd++;
            } else {
                odd--;
            }
            freqArr[num]++;
        }
        return odd == 0;
    }

    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        System.out.println(divideArray(new int[]{1, 2, 3, 4}));
    }

}
