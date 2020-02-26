package com.ecnu.liu.algorithm.leetcode.brutal;

import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-02-26
 * @modified By:
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Practice113 {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        path(result, new ArrayList<>(), root, sum, 0);
        return result;
    }


    private static void path(List<List<Integer>> result, List<Integer> list, TreeNode treeNode, int sum, int nowSum) {
        nowSum += treeNode.val;
        list.add(treeNode.val);
        if (treeNode.left == null && treeNode.right == null) {
            if (nowSum == sum) {
                result.add(list);
            }
            return;
        }
        if (treeNode.left != null) {
            path(result, new ArrayList<>(list), treeNode.left, sum, nowSum);
        }
        if (treeNode.right != null) {
            path(result, new ArrayList<>(list), treeNode.right, sum, nowSum);
        }
    }

    /**
     * [5,4,8,11,null,13,4,7,2,null,null,5,1]
     * 22
     * @param args
     */
    public static void main (String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;
        pathSum(node1, 22);
    }

}
