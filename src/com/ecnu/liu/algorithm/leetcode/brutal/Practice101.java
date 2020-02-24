package com.ecnu.liu.algorithm.leetcode.brutal;

import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-02-24
 * @modified By:
 */
public class Practice101 {

    /**
     * 思路一，中序遍历，看结果是否对称
     * @param root
     * @return
     */



    /**
     * 错误解法，这个只能保证每个节点的子节点是左右对称的。
     * @param root
     * @return
     */
//    public boolean isSymmetric (TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (root.left == null && root.right == null) {
//            return true;
//        } else if (root.right == null) {//上面的条件已经过滤了两种同时为空的情况
//            return false;
//        } else if (root.left == null) {
//            return false;
//        } else {
//            if (root.left.val != root.right.val) {
//                return false;
//            } else {
//                return isSymmetric(root.left) && isSymmetric(root.right);
//            }
//        }
//    }

    /**
     * 错误解法，这个只能保证每个节点的子节点是左右对称的。
     * @param root
     * @return
     */
    public boolean isSymmetric (TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.right == null) {//上面的条件已经过滤了两种同时为空的情况
            return false;
        } else if (root.left == null) {
            return false;
        } else {
            if (root.left.val != root.right.val) {
                return false;
            } else {
                return isSymmetric(root.left.right) && isSymmetric(root.right.left)
                    && isSymmetric(root.left.left) && isSymmetric(root.right.right);
            }
        }
    }
}
