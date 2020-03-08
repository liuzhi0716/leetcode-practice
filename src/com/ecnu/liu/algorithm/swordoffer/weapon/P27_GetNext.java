package com.ecnu.liu.algorithm.swordoffer.weapon;

import com.ecnu.liu.algorithm.struct.TreeLinkNode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P27_GetNext {

    /**
     * 分情况讨论
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode.right == null) {
            if (pNode.next == null) return null; // 考虑是否是头节点
            if (pNode == pNode.next.left) return pNode.next;
            else {
                TreeLinkNode p1 = pNode;
                TreeLinkNode p2 = pNode.next;
                while (p2.next != null) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if (p2.left == p1) return pNode.next.next;
                else return null;
            }
        } else {
            TreeLinkNode temp = pNode.right;
            while (temp.left != null) temp = temp.left;
            return temp;
        }
    }

}

