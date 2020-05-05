package com.ecnu.liu.algorithm.swordoffer.brutal;


import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 *
 */
public class Practice51 {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot, pRoot);
    }

    public boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.val == right.val) {
            return isSymmetrical(left.left, right.right) && isSymmetrical(right.left, left.right);
        }
        return false;
    }
}
