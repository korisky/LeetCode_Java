package Ex601_900.Ex670_MaximumSwap;

public class Solution {

    /**
     * 转换2个数字的位置, 来达到最大值
     */
    public int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        int n = numStr.length();
        int[] lastSeen = new int[10];

        for (int i = 0; i < n; ++i) {
            lastSeen[numStr.charAt(i) - '0'] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int d = 9; d > numStr.charAt(i) - '0'; d--) {
                if (lastSeen[d] > i) {
                    char[] arr = numStr.toCharArray();
                    char tmp = arr[i];
                    arr[i] = arr[lastSeen[d]];
                    arr[lastSeen[d]] = tmp;
                    numStr = new String(arr);
                    return Integer.parseInt(numStr);
                }
            }
        }
        return num;
    }
}
