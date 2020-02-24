package com.ecnu.liu.algorithm.leetcode.brutal;

import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-02-24
 * @modified By:
 */
public class Practice102 {

    public List<List<Integer>> levelOrder (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode now = deque.poll();
                list.add(now.val);
                if (now.left != null) {
                    deque.offer(now.left);
                }
                if (now.right != null) {
                    deque.offer(now.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
