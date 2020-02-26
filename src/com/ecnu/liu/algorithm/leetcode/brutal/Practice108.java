package com.ecnu.liu.algorithm.leetcode.brutal;

import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-02-25
 * @modified By:
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice108 {


    /**
     * 难点，如何保证 每个节点的子树高度差为不超过1
     *
     * 把数组当中序遍历的结果，中间的值为根节点，就可以保证是平衡树了
     * @param nums
     * @return
     */
//    public TreeNode sortedArrayToBST(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return null;
//        }
//        int l = 0;
//        int r = nums.length;
//        int m = (l + r) / 2;
//        TreeNode head = new TreeNode(nums[m]);
//        if (head.left != null) {
//            head.left = buildTree(nums, l, m-1, head);
//        }
//        if (head.right != null) {
//            head.right = buildTree(nums, m + 1, r, head);
//        }
//        return head;
//    }
//
//    private TreeNode buildTree(int[] nums, int l, int r, TreeNode root) {
//        if (l > r) {
//            return null;
//        }
//        if (l == r) {
//            return new TreeNode(nums[l]);
//        }
//        int m = (l + r) / 2;
//        TreeNode now = new TreeNode(nums[m]);
//        if (root.left != null) {
//            root.left = buildTree(nums, l, m-1, now);
//        }
//        if (root.right != null) {
//            root.right = buildTree(nums, m+1, r,now);
//        }
//        return now;
//    }
}
