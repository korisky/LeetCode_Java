package Ex1_300.Ex121_to_150.Ex129_SumRoot2LeafNumbers;

public class Solution {
    public static class TreeNode {
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

    public static long theSum;

    public int sumNumbers(TreeNode root) {
//        theSum = 0;
//        if (root != null)
//            dfs(root, new StringBuilder());
//        return Math.toIntExact(theSum);
        if (root != null)
            return dfsImproved(root, 0);
        return 0;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            long curNum = Long.parseLong(sb.toString());
            theSum += curNum;
        } else {
            if (root.left != null) {
                dfs(root.left, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (root.right != null) {
                dfs(root.right, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    /**
     * Rather than using a StringBuilder to temporarily store string,
     * because it's int, we can just pass the int value
     */

    public int dfsImproved(TreeNode root, int curSum) {
        curSum = 10 * curSum + root.val;
        if (root.left == null && root.right == null) {
            return curSum;
        } else {
            int sumSum = 0;
            if (root.left != null)
                sumSum += dfsImproved(root.left, curSum);
            if (root.right != null)
                sumSum += dfsImproved(root.right, curSum);
            return sumSum;
        }
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(9);
        t3.left = t1;
        t3.right = t2;
        TreeNode t4 = new TreeNode(0);
        TreeNode root = new TreeNode(4);
        root.left = t3;
        root.right = t4;
        System.out.println(use.sumNumbers(root));
    }
}
