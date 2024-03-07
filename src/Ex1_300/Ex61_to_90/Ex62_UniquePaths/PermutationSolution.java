package Ex1_300.Ex61_to_90.Ex62_UniquePaths;

/*
    The number of right and down would be STATIC, then the path would
    become a permutation problem:
        we denote: r represents how many right steps we can do, so as d for downwards
        formula: (r + d) ! / r! * d!

        if we let r > d:
            above formula can be simple as: (r+d) * (r+d-1) * ... (r+1) / d * d-1 * d-2 ... * 1
            then we can use a dimple for loop that keep * (r + index) then / index until index = d
 */

public class PermutationSolution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if (m < n) { // not extra space swapping, make sure m > n
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long result = 1;
        for (int index = 1; index <= n; index++) {
            result *= (m + index);
            result /= index;
        }
        return (int) result;
    }
}
