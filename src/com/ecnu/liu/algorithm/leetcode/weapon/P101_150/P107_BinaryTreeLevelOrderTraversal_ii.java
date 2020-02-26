package com.ecnu.liu.algorithm.leetcode.weapon.P101_150;

import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其自底向上的层次遍历为：

 [
 [15,7],
 [9,20],
 [3]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P107_BinaryTreeLevelOrderTraversal_ii {

    /**
     * BFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int len = 0;
        while (queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            len = queue.size();
            while (len > 0) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                len--;
            }
            ret.add(0, list);
        }
        return ret;
    }

    /**
     * DFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if (root == null) return ret;
        run(root, 0);
        return ret;
    }

    public void run(TreeNode node, int level) {
        List<Integer> list = null;
        if (ret.size() == level) {
            list = new ArrayList<>();
            ret.add(0, list);
        } else {
            list = ret.get(ret.size()-level-1);
        }
        list.add(node.val);
        if (node.left != null) run(node.left, level+1);
        if (node.right != null) run(node.right, level+1);
    }

}
