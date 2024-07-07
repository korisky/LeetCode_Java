package Ex1501_1800.Ex1518_WaterBottles;

public class Solution {

    public static int numWaterBottles(int numBottles, int numExchange) {
        int drunkTimes = numBottles;
        while (numBottles / numExchange > 0) {
            int newBottles = numBottles / numExchange;
            drunkTimes += newBottles;
            numBottles = numBottles % numExchange + newBottles;
        }
        return drunkTimes;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4));
        System.out.println(numWaterBottles(9, 3));
    }
}
