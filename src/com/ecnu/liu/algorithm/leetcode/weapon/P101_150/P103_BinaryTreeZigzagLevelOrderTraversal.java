package com.ecnu.liu.algorithm.leetcode.weapon.P101_150;

import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回锯齿形层次遍历如下：

 [
 [3],
 [20,9],
 [15,7]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P103_BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 层次遍历，BFS
     * 时间复杂丢：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int len = 0;
        int level = 1;
        while (queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            len = queue.size();
            while (len > 0) {
                TreeNode node = queue.removeFirst();

                if (level % 2 == 0) list.add(0, node.val);
                else list.add(node.val);

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                len--;
            }
            level++;
            ret.add(list);
        }
        return ret;
    }

}
