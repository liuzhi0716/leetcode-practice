package com.ecnu.liu.algorithm.leetcode.weapon.P101_150;

import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定有序数组: [-10,-3,0,5,9],

 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

 0
 / \
 -3   9
 /   /
 -10  5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P108_ConvertSortedArrayToBinarySearchTree {

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST1(int[] nums) {
        if (nums.length == 0) return null;
        return run(nums, 0, nums.length-1);
    }

    public TreeNode run(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        if (right - left == 1) mid = right;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = run(nums, left, mid-1);
        node.right = run(nums, mid+1, right);
        return node;
    }

}
