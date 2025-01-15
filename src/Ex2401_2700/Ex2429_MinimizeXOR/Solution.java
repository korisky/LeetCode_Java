package Ex2401_2700.Ex2429_MinimizeXOR;

public class Solution {

    public int minimizeXor(int num1, int num2) {

        int result = 0;
        int num2Bits = Integer.bitCount(num2);
        int setBitsCount = 0;

        // start from most significant bit
        int curBit = 31;

        while (setBitsCount < num2Bits) {
            if (isSet(num1, curBit) || (num2Bits - setBitsCount > curBit)) {
                result = setBit(result, curBit);
                setBitsCount++;
            }
            curBit--;
        }

        return result;
    }

    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }
}
