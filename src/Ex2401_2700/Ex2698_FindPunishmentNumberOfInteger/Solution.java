package Ex2401_2700.Ex2698_FindPunishmentNumberOfInteger;

public class Solution {

    public int punishmentNumber(int n) {
        int punishmentNum = 0;
        for (int curNum = 1; curNum <= n; curNum++) {
            int squareNum = curNum * curNum;

            if (canPartition(Integer.toString(squareNum), curNum)) {
                punishmentNum += squareNum;
            }
        }
        return punishmentNum;
    }

    private boolean canPartition(String strNum, int target) {
        if (strNum.isBlank() && target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        for (int i = 0; i < strNum.length(); i++) {
            String left = strNum.substring(0, i + 1);
            String right = strNum.substring(i + 1);
            int leftNUm = Integer.parseInt(left);

            if (canPartition(right, target - leftNUm)) {
                return true;
            }
        }
        return false;
    }
}
