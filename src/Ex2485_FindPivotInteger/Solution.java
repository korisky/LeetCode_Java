package Ex2485_FindPivotInteger;

public class Solution {
    /**
     * Binary Search 二分法查找
     */
    public int pivotInteger(int n) {

        int leftBound = 1, rightBound = n;
        int fullSum = (n * (n + 1)) / 2;

        while (leftBound <= rightBound) {

            // 每次查找获取中间值
            int midNum = leftBound + (rightBound - leftBound) / 2;
            int firstHlfSum = (midNum * (midNum + 1)) / 2;
            int secondHelfSum = fullSum - firstHlfSum + midNum;

            if (firstHlfSum == secondHelfSum) {
                return midNum;
            } else if (firstHlfSum < secondHelfSum) {
                leftBound = midNum + 1;
            } else {
                rightBound = midNum - 1;
            }
        }
        return -1;
    }
}
