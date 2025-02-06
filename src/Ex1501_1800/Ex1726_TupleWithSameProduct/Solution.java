package Ex1501_1800.Ex1726_TupleWithSameProduct;

import java.util.*;

public class Solution {


    public static class Combination {
        public int a;
        public int b;
        public long multi;

        public Combination(int a, int b) {
            this.a = a;
            this.b = b;
            this.multi = a * b;
        }
    }

    // better taking care of Integer overflow
    public static long combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }


    public static int tupleSameProduct(int[] nums) {

        // freq of multi
        Map<Long, List<Combination>> freqMap = new HashMap<>();

        // calculate Combination
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Combination combination = new Combination(nums[i], nums[j]);
                List<Combination> list = freqMap.getOrDefault(combination.multi, new ArrayList<>());
                list.add(combination);
                freqMap.put(combination.multi, list);
            }
        }

        // check combination
        long answer = 0;
        for (Map.Entry<Long, List<Combination>> entry : freqMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                // calculate combination
                answer += 8 * combination(entry.getValue().size(), 2);
            }
        }
        return (int) answer;
    }

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2, 3, 4, 6}));
        System.out.println(tupleSameProduct(new int[]{1, 2, 4, 5, 10}));
        System.out.println(tupleSameProduct(new int[]{2, 3, 4, 6, 8, 12}));
    }
}
