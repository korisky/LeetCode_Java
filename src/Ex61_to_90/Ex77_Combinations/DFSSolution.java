package Ex61_to_90.Ex77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class DFSSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfsGetComb(results, new ArrayList<>(), 0, n - 1, k);
        return results;
    }

    public void dfsGetComb(List<List<Integer>> results, ArrayList<Integer> curComb,
                           int start, int end, int depthLeft) {
        if (depthLeft == 0) {
            results.add(new ArrayList<>(curComb));
        } else {
            for (int i = start; i <= end; i++) {
                curComb.add(i + 1);
                dfsGetComb(results, curComb, i + 1, end, depthLeft - 1);
                curComb.remove(curComb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        DFSSolution use = new DFSSolution();
        System.out.println(use.combine(3, 2));
    }
}
