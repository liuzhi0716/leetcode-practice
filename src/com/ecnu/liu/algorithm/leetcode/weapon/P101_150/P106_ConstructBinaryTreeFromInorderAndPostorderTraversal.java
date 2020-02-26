package com.ecnu.liu.algorithm.leetcode.weapon.P101_150;

import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 中序遍历 inorder = [9,3,15,20,7]
 后序遍历 postorder = [9,15,7,20,3]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private Map<Integer, Integer> inMap = new HashMap<>();

    /**
     * DFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        for (int i=0; i<inorder.length; i++) inMap.put(inorder[i], i);
        return run(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode run(int[] inorder, int[] postorder,
                        int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) return null;
        int mid = inMap.get(postorder[postRight]);

        TreeNode node = new TreeNode(postorder[postRight]);
        node.left = run(inorder, postorder, inLeft, mid-1, postLeft, postLeft+mid-inLeft-1);
        node.right = run(inorder, postorder, mid+1, inRight, postLeft+mid-inLeft, postRight-1);
        return node;
    }
}
