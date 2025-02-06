package Ex1501_1800.Ex1726_TupleWithSameProduct;

import java.util.HashMap;

public class FasterSolution {

    /**
     * Rather than use 'frequency map', use map's 'merge' function instead
     */
    public int tupleSameProduct(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                count += (8 * map.getOrDefault(product, 0));

                // tricks here, if no key in map -> use 1 as default, contains key in map -> add 1 together to replace
                map.merge(product, 1, Integer::sum);
            }
        }
        return count;
    }
}
