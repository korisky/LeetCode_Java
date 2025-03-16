package Ex2401_2700.Ex2594_MinimumTimeToRepairCars;

public class Solution {

    /**
     * Binary search -> on given time
     */
    public long repairCars(int[] ranks, int cars) {
        // l is the minimum minute
        // r is the maximum minute
        long l = 1, r = (long) 1e14;
        while (l < r) {
            long mid = (l + r) / 2;
            // using binary search to check whether current time is sufficient
            if (timeIsSuff(ranks, cars, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean timeIsSuff(int[] ranks, int cars, long minGiven) {
        long carsDone = 0;
        for (int rank : ranks) {
            long c2 = minGiven / rank;
            long c = (long) Math.sqrt(c2);
            carsDone += c;
        }
        return carsDone >= cars;
    }
}
