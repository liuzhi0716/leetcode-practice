package com.ecnu.liu.algorithm.leetcode.weapon.P101_150;

import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

 本题中，一棵高度平衡二叉树定义为：

 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

 示例 1:

 给定二叉树 [3,9,20,null,null,15,7]

 3
 / \
 9  20
 /  \
 15   7
 返回 true 。

 示例 2:

 给定二叉树 [1,2,2,3,3,null,null,4,4]

 1
 / \
 2   2
 / \
 3   3
 / \
 4   4
 返回 false 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P110_BalancedBinaryTree {

    /**
     * 自下向上递归判断
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    boolean flag = true;
    public boolean isBalanced1(TreeNode root) {
        height(root);
        return flag;
    }

    public int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left) + 1;
        int right = height(node.right) + 1;

        if (Math.abs(left-right) > 1) flag = false;
        return Math.max(left, right);
    }
}
