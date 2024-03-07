package Ex901_1200.Ex977_SquaresOfASortedArray;

public class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int leftIdx = 0;
        int rightIdx = res.length - 1;
        int pointer = res.length - 1;

        while (leftIdx <= rightIdx) {
            if (Math.abs(A[leftIdx]) >= Math.abs(A[rightIdx])) {
                res[pointer--] = A[leftIdx] * A[leftIdx];
                leftIdx++;
            } else {
                res[pointer--] = A[rightIdx] * A[rightIdx];
                rightIdx--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{-7,-3,2,3,11};
        int[] res = use.sortedSquares(test);
        for (int i : res)
            System.out.println(i);
    }
}
