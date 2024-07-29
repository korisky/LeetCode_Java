package Ex1201_1500.Ex1395_CountNumberTeams;

import java.util.Arrays;

public class Solution {

    public int numTeams(int[] rating) {

        // Find the maximum rating
        int maxRating = Arrays.stream(rating).max().getAsInt();

        int[] leftBit = new int[maxRating + 1];
        int[] rightBit = new int[maxRating + 1];

        // populate the right bit with all ratings initially
        for (int r : rating) {
            updateBit(rightBit, r, 1);
        }

        int teams = 0;
        for (int curRating : rating) {

            // remove current rating from right bit
            updateBit(rightBit, curRating, -1);

            // count soldiers with smaller and larger ratings on both sides
            int smallerRatingLeft = getPrefixSum(leftBit, curRating - 1);
            int smallerRatingRight = getPrefixSum(rightBit, curRating - 1);
            int largerRatingLeft = getPrefixSum(leftBit, maxRating) - getPrefixSum(leftBit, curRating);
            int largerRatingRight = getPrefixSum(rightBit, maxRating) - getPrefixSum(rightBit, curRating);

            // counting increasing and decreasing sequences
            teams += (smallerRatingLeft * largerRatingRight);
            teams += (largerRatingLeft * smallerRatingRight);

            // add current rating to left bit
            updateBit(leftBit, curRating, 1);
        }
        return teams;
    }

    /**
     * Update Binary Indexed Tree
     */
    private void updateBit(int[] bit, int idx, int val) {
        while (idx < bit.length) {
            bit[idx] += val;
            // move to next relevant index in bit
            idx += idx & (-idx);
        }
    }

    /**
     * Get the sum of all elements up to the given idx in bit
     */
    private int getPrefixSum(int[] bit, int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            // move to parent node in bit
            idx -= idx & (-idx);
        }
        return sum;
    }
}
