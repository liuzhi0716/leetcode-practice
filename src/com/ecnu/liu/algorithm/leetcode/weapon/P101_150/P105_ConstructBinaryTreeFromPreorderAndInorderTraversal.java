package com.ecnu.liu.algorithm.leetcode.weapon.P101_150;

import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * DFS
     * 时间复杂度：O(nlog2(n))
     * 空间复杂度：O(n)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return run(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode run(int[] preorder, int[] inorder,
                        int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;

        int temp = preorder[preLeft];
        int i = inLeft;
        for(i=inLeft; i<=inRight; i++) {
            if (inorder[i] == temp) break;
        }
        TreeNode node = new TreeNode(temp);
        node.left = run(preorder, inorder, preLeft+1, preLeft+i-inLeft,
                inLeft, i-1);
        node.right = run(preorder, inorder, preLeft+i-inLeft+1, preRight, i+1, inRight);
        return node;
    }

}
