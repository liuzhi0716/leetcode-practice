package com.ecnu.liu.algorithm.leetcode.weapon.P101_150;

import com.ecnu.liu.algorithm.struct.ListNode;
import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定的有序链表： [-10, -3, 0, 5, 9],

 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

 0
 / \
 -3   9
 /   /
 -10  5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P109_ConvertSortedListToBinarySearchTree {

    /**
     * 链表转数组，再递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    List<Integer> list = new ArrayList<>();
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return run(0, list.size()-1);
    }

    public TreeNode run(int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        if (right - left == 1) mid = right;

        TreeNode node = new TreeNode(list.get(mid));
        node.left = run(left, mid-1);
        node.right = run(mid+1, right);
        return node;
    }

}
