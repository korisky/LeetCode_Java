package EX31_to_60.Ex60_PermutationSequence;

/*
    The question is quite different from the other Permutation problem:

    e.g. n = 4, k = 14, we have {1, 2, 3, 4}

    List out the permutations:
        1 + (permutation of {2, 3, 4})
        2 + (permutation of {1, 3, 4})
        3 + (permutation of {1, 2, 4})
        4 + (permutation of {1, 2, 3})


    As we can see, each of this subset of permutation contains: 1 x 3! = 3 x 2 x 1 = 6 sub-sub-set permutations
    Then we can locate the 14th permutation is on subset of 3 + (permutation of {1, 2, 4}).

    Also, as we know the first permutation in 3 + (permutation of {1, 2, 4}) is the 13th permutation. Then we can
    divide the sub-problem into sub-sub-problem:
    3 + 1 + (permutation of {2, 4})
    3 + 2 + (permutation of {1, 4})
    3 + 4 + (permutation of {1, 2})
    We need to find the 2nd permutation in all these sub-sub-problem, then we know
    it must be in 3 + 1 + (permutation of {2, 4})

    in sub-sub-sub-problem: 2 4 & 4, 2.........

    Finally, we get 3, 1, 4, 2 as the 14th permutation


 */

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> nums = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int[] factorial = new int[n];
        factorial[0] = 1; // 0! = 1
        for (int i = 1; i < n; i++) { // e.g. for {1, 2, 3, 4}, we only need 1 + {2, 3, 4}
            factorial[i] = i * factorial[i - 1];
            nums.add(i);
        }
        nums.add(n);

        k--; // 0 - 13 as 14th
        for (int i = n - 1; i >= 0; i--) { // use the biggest 1 + {...} 2 + {...} to locate first, then subset
            int index = k / factorial[i]; // after k-1, we can locate the REAL element we use
                                        // this index would be the exactly one we need
            k = k % factorial[i]; // the remaining
            sb.append(nums.get(index));
            nums.remove(index); // with removing the using index, we can keep reaching the real number we need
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.getPermutation(4, 14));
    }
}
