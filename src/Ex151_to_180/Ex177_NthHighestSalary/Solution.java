package Ex151_to_180.Ex177_NthHighestSalary;

public class Solution {
    /**
     * 这里使用Offset, 对结果集进行更快速的操作
     *
     * CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
     * BEGIN
     * DECLARE M INT;
     * SET M=N-1;
     *   RETURN (
     *       # Write your MySQL query statement below.
     *       SELECT DISTINCT(salary) FROM Employee ORDER BY salary DESC LIMIT M, 1
     *   );
     * END
     */
}
