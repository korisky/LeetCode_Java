package Ex1801_2100.Ex1894_FindStudentWillReplaceChalk;

import java.util.Arrays;

public class Solution {

    public int chalkReplacer(int[] chalk, int k) {

        // 核心考点在这, 由于大量的int叠加有可能导致溢出, 所以需要使用long类型
        // 但使用stream时如果不加指定 (asLongStream), 内部还是会认为是int, sum操作也会是int
        // 从而导致溢出, 结果不对
        long eachIter = Arrays.stream(chalk)
                .asLongStream()
                .sum();
        int remainingChalk = (int) (k % eachIter);
        int student = 0;
        for (int consume : chalk) {
            remainingChalk -= consume;
            if (remainingChalk < 0) {
                return student;
            }
            student++;
        }
        return 0;
    }
}
