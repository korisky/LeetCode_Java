package Ex601_900.Ex863_AllNodesDistanceKBinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 题目核心,
 * 1) 首先进行dfs, 对所有(左子树或右子树)可以抵达target节点的部分, 进行路径记录到map中
 * 2) 再次遍历, 如果map中的
 */
public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static Map<TreeNode, Integer> map = new HashMap<>();
    static List<Integer> res = new LinkedList<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 1. dfs进行遍历时, 同时考虑存储到达target的距离, 使用map进行存储
        dfsForPut(root, target);
        // 2. dfs再遍历一遍, 对距离为k的节点进行保存
        dfsForRetrieve(root, k, 0);
        return res;
    }

    private static int dfsForPut(TreeNode root, TreeNode target) {

        // 不可达的返回-1
        if (root == null) {
            return -1;
        }

        // 到达target, 将其保存距离为0
        if (root.val == target.val) {
            map.put(root, 0);
            return 0;
        }

        // 左子树遍历, 如果返回的部分>=0就是能到达target, 对目前距离+1返回, 并且保存到map中
        int left = dfsForPut(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }

        // 右子树遍历, 类似
        int right = dfsForPut(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }

        // 不可达的返回-1
        return -1;
    }

    /**
     * 遍历寻找长度为k距离抵达target的所有node, 这里的重点是, 必须通过get来获取length, 然后再持续调用length+1递归
     * 如果直接遍历map, 实际上length是不对的
     */
    private static void dfsForRetrieve(TreeNode root, int k, int length) {

        if (root == null) {
            return;
        }

        // 当map存在这个节点, 证明它可以抵达target, 这里将length进行设置
        if (map.containsKey(root)) {
            length = map.get(root);
        }

        // 只有它的length与目标k相同, 才保存到res中
        if (length == k) {
            res.add(root.val);
        }

        // 遍历左子树和右子树, length 必须+1, 因为containsKey中保存的val可能会缺少其中一跳
        dfsForRetrieve(root.left, k, length + 1);
        dfsForRetrieve(root.right, k, length + 1);
    }

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode six = new TreeNode(6);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);
        TreeNode one = new TreeNode(1);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);

        three.left = five;
        three.right = one;
        one.left = zero;
        one.right = eight;
        five.left = six;
        five.right = two;
        two.left = seven;
        two.right = four;

        System.out.println(distanceK(three, new TreeNode(5), 2));
    }
}
