package Ex2401_2700.Ex2657_FindPrefixCommonTwoArrays;

public class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        int[] frequency = new int[n + 1];
        int commonCount = 0;
        for (int curIdx = 0; curIdx < n; curIdx++) {
            frequency[A[curIdx]] += 1;
            if (frequency[A[curIdx]] == 2) {
                commonCount++;
            }
            frequency[B[curIdx]] += 1;
            if (frequency[B[curIdx]] == 2) {
                commonCount++;
            }
            prefixCommonArray[curIdx] = commonCount;
        }
        return prefixCommonArray;
    }
}
