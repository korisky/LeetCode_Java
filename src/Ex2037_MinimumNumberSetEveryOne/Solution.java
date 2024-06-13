package Ex2037_MinimumNumberSetEveryOne;

import java.util.Arrays;

public class Solution {

    /**
     * 尝试使用最简单的Sort + Greedy -> O(log_2{N})
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }
}
