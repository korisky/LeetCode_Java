package Ex1501_1800.Ex1552_MagneticForceBetweenTwoBalls;

import java.util.Arrays;

public class Solution {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1;
        int hi = (position[position.length - 1] - position[0]) / (m - 1);
        int ans = 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canPlace(position, mid, m)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canPlace(int[] arr, int dist, int cows) {
        int cntCows = 1;
        int last = arr[0];
        for (int j : arr) {
            if (j - last >= dist) {
                cntCows++;
                last = j;
            }
            if (cntCows >= cows) {
                return true;
            }
        }
        return false;
    }
}
