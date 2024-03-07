package Ex301_600.Ex481_to_510.Ex495_TeemoAttacking;

public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if (timeSeries == null || timeSeries.length == 0)
            return 0;

        int poisonStart = Integer.MAX_VALUE;
        int poisonEnd = Integer.MIN_VALUE;
        int counting = -1; // Integer.MIN_VALUE - Integer.MAX_VALUE = -1

        for (int attackStart : timeSeries) {
            if (attackStart <= poisonEnd) {
                poisonEnd = Math.max(poisonEnd, attackStart + duration);
            } else {
                counting += (poisonEnd - poisonStart);
                poisonStart = attackStart;
                poisonEnd = attackStart + duration;
            }
        }
        counting += (poisonEnd - poisonStart);
        return counting;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        System.out.println(use.findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
