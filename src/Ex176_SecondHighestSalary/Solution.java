package Ex176_SecondHighestSalary;

public class Solution {
    /**
     * SELECT MAX(e.salary) AS SecondHighestSalary
     * FROM Employee e
     * WHERE e.salary NOT IN(SELECT MAX(ee.salary) FROM Employee ee)
     * ORDER BY e.salary DESC
     * LIMIT 1;
     */
}
