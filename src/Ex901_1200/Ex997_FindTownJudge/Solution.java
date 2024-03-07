package Ex901_1200.Ex997_FindTownJudge;

public class Solution {

    public static void main(String[] args) {
        int[] trust = new int[]{1, 2};
        int[][] allTrust = new int[][]{trust};

        int judge = findJudge(2, allTrust);
        System.out.println(judge);
    }

    /**
     * 题目需要找到是否符合单项图中的终点, 使用简单的record即可实现
     */
    public static int findJudge(int n, int[][] trust) {

        int[] trustedRecord = new int[n + 1];

        for (int[] singleTrust : trust) {
            int trustOthers = singleTrust[0];
            int beTrusted = singleTrust[1];
            trustedRecord[trustOthers] = -1;
            trustedRecord[beTrusted] = (trustedRecord[beTrusted] < 0)
                    ? -1 : trustedRecord[beTrusted] + 1;
        }

        int theJudgeIdx = -1;
        for (int i = 1; i < trustedRecord.length; i++) {
            if (trustedRecord[i] == n - 1) {
                if (theJudgeIdx != -1) {
                    // 两个 judge 也错
                    return -1;
                } else {
                    // 一个judge
                    theJudgeIdx = i;
                }
            }
        }
        return theJudgeIdx;
    }
}
