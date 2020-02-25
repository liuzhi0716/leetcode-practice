package com.ecnu.liu.algorithm.leetcode.weapon.P101_150;

import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

  1
 / \
 2   2
 \   \
 3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/symmetric-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P101_SymmetricTree_0225 {

    /**
     * 层次遍历法
     * 时间复杂度：
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        List<Integer> list = new ArrayList<>();
        int len = 0;
        while (queue.size() > 0) {
            len = queue.size();
            while (len > 0) {
                TreeNode node = queue.removeFirst();
                if (node != null && node.left != null) {
                    list.add(node.left.val);
                    queue.addLast(node.left);
                } else {
                    list.add(null);
                    queue.addLast(null);
                }
                if (node != null && node.right != null) {
                    list.add(node.right.val);
                    queue.addLast(node.right);
                } else {
                    list.add(null);
                    queue.addLast(null);
                }
                len--;
            }
            if (list.size() % 2 == 1) return false;
            if (list.size() > 0) {
                int left=0, right=list.size()-1;
                int num = 0;
                while (left < right) {
                    if (list.get(left) != list.get(right)) return false;
                    if (list.get(left) == list.get(right) && list.get(left) == null) num+=2;
                    left++;
                    right--;
                }
                if (num == list.size()) break;
                list.clear();
            }
        }
        return true;
    }
}
