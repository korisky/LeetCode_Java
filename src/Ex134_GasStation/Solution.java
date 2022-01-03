package Ex134_GasStation;

/*
    The idea is about: we keep two stuff:
        1) the total gaining, which is about sum up all gas we can get
        and minus all cost we use, until we reach the station of i. There is
        no matter of the 'order' of the station we should start, if it's valid, then
        this total gaining must >= 0, or else must not have any valid path

        2) current gaining, is to judge whether a start point is valid.

        why it works?
        Because if there is a solution, that we can run all station, it must can be run from any station as start
 */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGaining = 0;
        int curGaining = 0;
        int candidate = 0;

        for (int idx = 0; idx < gas.length; idx++) {
            totalGaining += gas[idx] - cost[idx];
            curGaining += gas[idx] - cost[idx];
            if (curGaining < 0) {
                curGaining = 0;
                candidate = idx + 1;
            }
        }
        return totalGaining > 0 ? candidate : -1;
    }
}
