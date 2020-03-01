package com.ecnu.liu.algorithm.swordoffer.weapon;

import com.ecnu.liu.algorithm.struct.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P7_HasSubtree {

    /**
     * 递归判断
     * 最坏时间复杂度：O(M*N)
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return false;
        if (root1 == null && root2 != null) return false;
        boolean flag = compare(root1, root2);
        if (!flag) {
            flag = HasSubtree(root1.left, root2);
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    public boolean compare(TreeNode node1,TreeNode node2){
        if (node2 == null) return true;
        if (node1 == null && node2 != null) return false;
        if (node1.val == node2.val) {
            return compare(node1.left, node2.left) && compare(node1.right, node2.right);
        } else {
            return false;
        }
    }
}
