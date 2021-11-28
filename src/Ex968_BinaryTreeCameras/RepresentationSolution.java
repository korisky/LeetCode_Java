package Ex968_BinaryTreeCameras;


/**
 * 使用  0: 代表是被监控的父节点
 * 使用  1: 代表这个节点是监控节点
 * 使用 -1: 代表这个节点需要被父节点监控
 */
public class RepresentationSolution {

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

    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == -1) {
            // return node need one more camera
            cameras++;
        }
        return cameras;
    }

    public int dfs(TreeNode root) {
        // left node is special cases, null-left is not our watching node,
        // thus, just give it 0 as no need to care them
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // if left and right sub-trees all been watch by their child
        if (left == 0 && right == 0) {
            return -1;
        }
        if (left == -1 || right == -1) {
            cameras++;
            return 1;
        }
        return 0;
    }

}
