package Ex1501_1800.Ex1700_NumberUnableEatLunch;

public class Solution {

    /**
     * 题目虽然阐述上说遇到不喜欢的sandwich的学生需要重新排队, 但实际上这个动作并不影响我们进行计算
     * 这里可以通过直接的计算0和1的学生总数, 进行sandwich遍历, 核心在于:
     * - 如果当前遇到了sandwich为1, 但是要1的学生已经没有了, 学生只能自己向后排队, 无法转换sandwich的位置, 这个时候这些要1的学生一定就是剩余吃不上饭的 (因为学生怎么排队都没有要1的都是0)
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int one = 0, zero = 0;

        // 遍历学生, 确认他们的选择
        for (int student : students) {
            if (student == 0) {
                zero++;
            } else {
                one++;
            }
        }

        // 遍历sandwich, 遇到其中一个为0的情况 (e.g. 要0的student已经空了, 那么要1的student就是喂不饱的几个了)
        for (int sandwich : sandwiches) {
            if (sandwich == 1) {
                // 当前sandwich给1
                if (one == 0) {
                    // 如果这时候已经没有要1的学生, 可以提取剪支, 直接返回还有的要0的学生数量
                    return zero;
                }
                one--;
            } else {
                // 当前sandwich给0
                if (zero == 0) {
                    return one;
                }
                zero--;
            }
        }
        return 0;
    }
}
