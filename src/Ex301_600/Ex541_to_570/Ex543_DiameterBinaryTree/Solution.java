package Ex301_600.Ex541_to_570.Ex543_DiameterBinaryTree;

public class Solution {


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

    public class DiameterData {
        int diameter;
        int height;

        public DiameterData(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public DiameterData calculateDiameterAndHeight(TreeNode root) {

        // 递归的终点
        if (root == null) {
            return new DiameterData(0, 0);
        }

        // 深度遍历, 左子树, 右子树
        DiameterData left = calculateDiameterAndHeight(root.left);
        DiameterData right = calculateDiameterAndHeight(root.right);

        // 直径的特殊处理, 要么是左右子树的和, 要么是左子树或右子树中的一个
        int curDiameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter));

        // 当前height + 1
        int curHeight = Math.max(left.height, right.height) + 1;

        return new DiameterData(curDiameter, curHeight);
    }


    public int diameterOfBinaryTree(TreeNode root) {
        return calculateDiameterAndHeight(root).diameter;
    }
}
