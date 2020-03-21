package com.ecnu.liu.algorithm.leetcode.weapon.P51_100;

import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

 假设一个二叉搜索树具有如下特征：

 节点的左子树只包含小于当前节点的数。
 节点的右子树只包含大于当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。
 示例 1:

 输入:
 2
 / \
 1   3
 输出: true
 示例 2:

 输入:
 5
 / \
 1   4
 / \
 3   6
 输出: false
 解释: 输入为: [5,1,4,null,null,3,6]。
 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class P98_IsValidBST_0321 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!(com(root.left, root.val, true) && com(root.right, root.val, false))) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean com(TreeNode node, int val, boolean isLeft) {
        if (node == null) return true;
        if (isLeft && node.val >= val) return false;
        if (!isLeft && node.val <= val) return false;
        return com(node.left, val, isLeft) && com(node.right, val, isLeft);
    }

}
