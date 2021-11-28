package Ex508_MostFrequentSubtreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 重点在于理解题目, 要么是叶子节点自己的值(0 + 0 + cur.val), 要么是子树的和(left.val + right.val + cur.val)
 * 还需要注意, 可能会出现多个同样频率的值, 所以要遍历
 */
public class DfsSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // we might encounter a couple of sum have same frequency, thus, we still need to travel the map
    int maxFre = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap<>();
        // do the travel
        int travelHead = dfs(root, freq);
        // find out the maximum frequency keys
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFre) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public int dfs(TreeNode root, Map<Integer, Integer> freq) {
        // bottom case
        if (root == null) {
            return 0;
        }
        // add sum
        int curSubSum = root.val + dfs(root.left, freq) + dfs(root.right, freq);
        // record it into the frequency map
        Integer curFreq = freq.getOrDefault(curSubSum, 0) + 1;
        freq.put(curSubSum, curFreq);
        // update the max frequency
        maxFre = Math.max(maxFre, curFreq);
        return curSubSum;
    }

}
