package Ex1501_1800.Ex1550_ThreeConsecutiveOdds;

public class Solution {

    public static boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length <= 2) {
            return false;
        }
        int l = 0, r = 0;
        while (r < arr.length) {
            if (arr[r] % 2 == 1) {
                while (arr[l] % 2 == 0 && l < r) {
                    l++;
                }
                if (r - l >= 2) {
                    return true;
                }
            }
            if (arr[r] % 2 == 0) {
                l = r;
            }
            r++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        System.out.println(threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
        System.out.println(threeConsecutiveOdds(new int[]{1, 3, 2}));
        System.out.println(threeConsecutiveOdds(new int[]{1, 1, 2, 1, 1}));
    }
}
