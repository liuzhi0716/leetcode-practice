package com.ecnu.liu.algorithm.leetcode.brutal;

import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-02-25
 * @modified By:
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice105 {

    /**
     * 思路  前序遍历中的值，是从上到下的，所以是根节点，可以将中序中以它为界分成两部分，左边是左子树，右边是右子树，以此类推到每个节点
     * @param preorder
     * @param inorder
     * @return
     */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        for (int i = 0; i < preorder.length; i++) {
//
//
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//        for (int i = 0; i < inorder.length; i++) {
//            if (root.val == inorder[i]) {
//                root.left =
//            }
//        }
//    }

}
