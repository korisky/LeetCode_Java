package Ex601_900.Ex670_MaximumSwap;

public class Solution {

    /**
     * 转换2个数字的位置, 来达到最大值
     */
    public static int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        int n = numStr.length();
        int[] lastSeen = new int[10];

        // 先遍历一遍, 确保0-9遇到过的数字
        for (int i = 0; i < n; ++i) {
            lastSeen[numStr.charAt(i) - '0'] = i;
        }

        for (int i = 0; i < n; i++) {
            // 从高到底开始, 针对遇到过的, 然后当前高位低过它的, 进行swap
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

    public static void main(String[] args) {
        System.out.println(maximumSwap(1058));
    }
}
