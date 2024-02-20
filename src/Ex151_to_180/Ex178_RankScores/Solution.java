package Ex151_to_180.Ex178_RankScores;

public class Solution {
    /**
     * 这里要考虑使用MySQL提供的Over函数, 配合Dense_Rank进行组合
     *
     * SELECT score, DENSE_RANK() OVER(ORDER BY score DESC) AS 'rank'
     * FROM Scores
     * ORDER BY 'rank'
     */
}
