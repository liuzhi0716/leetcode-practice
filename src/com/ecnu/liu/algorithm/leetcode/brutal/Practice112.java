package com.ecnu.liu.algorithm.leetcode.brutal;

import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-02-26
 * @modified By:
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice112 {

    public static boolean hasPathSum (TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return countSum(root, 0, sum);
    }

    private static boolean countSum (TreeNode root, int sum, int target) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                return true;
            }
            return false;
        } else if (root.left != null && root.right != null) {
            return countSum(root.left, sum, target) || countSum(root.right, sum, target);
        } else if (root.left == null) {
            return countSum(root.right, sum, target);
        } else {
            return countSum(root.left, sum, target);
        }
    }


    public static void main (String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        hasPathSum(t1, 1);
    }

}
