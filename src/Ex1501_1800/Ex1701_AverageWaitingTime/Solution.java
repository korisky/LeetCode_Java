package Ex1501_1800.Ex1701_AverageWaitingTime;

public class Solution {

    public double averageWaitingTime(int[][] customers) {
        double wait = 0;
        int t = -1;
        for (int[] a : customers) {
            t = Math.max(t, a[0]);
            t += a[1];
            wait += t - a[0];
        }
        return wait / customers.length;
    }
}
