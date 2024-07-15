package Ex2101_2400.Ex2196_CreateBinaryTreeFromDescriptions;

import java.util.*;

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

    /**
     * 相较于通过差集找到root后递归构建, 直接先构建最后判断root是快的一种方式
     */
    public TreeNode createBinaryTree_Faster(int[][] descriptions) {

        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = (description[2] == 1);

            if (!nodeMap.containsKey(parentVal)) {
                nodeMap.put(parentVal, new TreeNode(parentVal));
            }
            if (!nodeMap.containsKey(childVal)) {
                nodeMap.put(childVal, new TreeNode(childVal));
            }
            if (isLeft) {
                nodeMap.get(parentVal).left = nodeMap.get(childVal);
            } else {
                nodeMap.get(parentVal).right = nodeMap.get(childVal);
            }
            childSet.add(childVal);
        }
        for (TreeNode node : nodeMap.values()) {
            if (!childSet.contains(node.val)) {
                return node;
            }
        }
        return null;
    }


    /**
     * 题目目标希望从description中重新构建起来整颗Tree
     */
    public TreeNode createBinaryTree(int[][] descriptions) {

        // 方便从root开始向下构建
        Map<Integer, Integer> leftSubMap = new HashMap<>();
        Map<Integer, Integer> rightSubMap = new HashMap<>();

        Set<Integer> subTreeRootSet = new HashSet<>();
        Set<Integer> subTreeChildSet = new HashSet<>();

        for (int[] description : descriptions) {
            int root = description[0];
            int child = description[1];
            subTreeRootSet.add(root);
            subTreeChildSet.add(child);
            // 判断左右子树
            if (description[2] == 1) {
                leftSubMap.put(root, child);
            } else {
                rightSubMap.put(root, child);
            }
        }

        // 筛选出来真正的root
        subTreeRootSet.removeAll(subTreeChildSet);
        if (subTreeRootSet.size() != 1) {
            throw new RuntimeException("Should only be one root");
        }
        int rootVal = (int) subTreeRootSet.toArray()[0];

        // 递归构建
        return dfsBuilding(rootVal, leftSubMap, rightSubMap);
    }

    /**
     * 深度遍历递归构建树
     */
    public TreeNode dfsBuilding(Integer rootVal,
                                Map<Integer, Integer> leftSubMap,
                                Map<Integer, Integer> rightSubMap) {

        TreeNode root = new TreeNode(rootVal);
        Integer leftChildVal = leftSubMap.getOrDefault(rootVal, null);
        Integer rightChildVal = rightSubMap.getOrDefault(rootVal, null);

        if (!Objects.isNull(leftChildVal)) {
            root.left = dfsBuilding(leftChildVal, leftSubMap, rightSubMap);
        }
        if (!Objects.isNull(rightChildVal)) {
            root.right = dfsBuilding(rightChildVal, leftSubMap, rightSubMap);
        }
        return root;
    }
}
