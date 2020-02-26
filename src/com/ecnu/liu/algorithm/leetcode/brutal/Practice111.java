package com.ecnu.liu.algorithm.leetcode.brutal;

import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-02-26
 * @modified By:
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice111 {


    /**一定要理清楚题意
     * 思路：
     * 很多人写出的代码都不符合 1,2 这个测试用例，是因为没搞清楚题意
     *
     * 题目中说明:叶子节点是指没有子节点的节点，这句话的意思是 1 不是叶子节点
     *
     * 题目问的是到叶子节点的最短距离，所以所有返回结果为 1 当然不是这个结果
     *
     * 另外这道题的关键是搞清楚递归结束条件
     *
     * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
     * 当 root 节点左右孩子都为空时，返回 1
     * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
     * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
     *
     * 作者：reals
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
       if (root == null) {
           return 0;
       }
       if (root.left == null && root.right == null) {
           return 1;
       }
       if (root.left != null && root.right != null) {
           return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
       }
       if (root.left != null) {
           return minDepth(root.left) + 1;
       } else {
           return minDepth(root.right) + 1;
       }

    }





}
