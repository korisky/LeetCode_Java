package Ex301_600.Ex541_to_570.Ex556_NextGreaterElementIII;

public class Solution {
    /**
     * 题目要求执行转换, 得到同样数字下下一个的值, 执行步骤分为: (与Ex31类似)
     * 1) 从右往前找, 找到第一个i<i+1, 确认i位置
     * 2) 从i往后找, 找到第一个j使得 j > i, j + 1 < i
     * 3) j和i数字swap
     * 4) i这个位置往后的数字, 进行reverse
     */
    public static int nextGreaterElement(int n) {


        char[] charArr = String.valueOf(n).toCharArray();
        int len = charArr.length;

        // 1. 右往左找, 找到第一个递减的数字
        int left = len - 2;
        while (left >= 0 && charArr[left] <= charArr[left + 1]) {
            left--;
        }
        if (left == -1) {
            return -1;
        }

        // 2. 在left这个位置往右找, 找到刚好>num[left]的
        int right = len - 1;
        while (right >= 0 && charArr[right] <= charArr[left]) {
            right--;
        }

        // 3. swap
        swap(charArr, left, right);

        // 4. 对left的右侧进行reverse, 可以看作切分, 然后reverse后拼接
        reverse(charArr, left + 1);

        // parseInt需要判断, 确保不要超出Integer的范围
        try {
            return Integer.parseInt(new String(charArr));
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
//        int result = nextGreaterElement(158476531);
//        assert result == 158513467;
        System.out.println(nextGreaterElement(11));
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverse(char[] arr, int start) {
        int l = start, r = arr.length - 1;
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }
}
