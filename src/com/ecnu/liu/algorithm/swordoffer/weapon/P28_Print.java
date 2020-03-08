package com.ecnu.liu.algorithm.swordoffer.weapon;

import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P28_Print {

    /**
     * BFS
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > ret = new ArrayList<>();
        if (pRoot == null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(pRoot);
        int step = 0;
        while (queue.size() > 0) {
            step++;
            ArrayList<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode temp = queue.removeFirst();
                if (step % 2 == 1) list.add(temp.val);
                else list.add(0, temp.val);
                if (temp.left != null) queue.addLast(temp.left);
                if (temp.right != null) queue.addLast(temp.right);
                len--;
            }
            ret.add(list);
        }
        return ret;
    }

}
