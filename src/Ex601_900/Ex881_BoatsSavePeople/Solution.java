package Ex601_900.Ex881_BoatsSavePeople;

import java.util.Arrays;

public class Solution {


    /**
     * 题目核心 -> 一条船至多坐2个人
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, ans = 0;
        while (i <= j) {
            ans++;
            // 如果可以同乘一条船, 则进行++, 相当于少跑一趟
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return ans;
    }
}
