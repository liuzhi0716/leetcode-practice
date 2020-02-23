package com.ecnu.liu.algorithm.leetcode.weapon;

import com.ecnu.liu.algorithm.struct.ListNode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:

 输入:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 输出: 1->1->2->3->4->4->5->6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P23_MergeKSortedLists {

    /**
     * 分治
     * 时间复杂度：O(log2(n) * sum(len(lists[i])))
     * 空间复杂度：O(1)
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        if (len == 1) return lists[0];
        else {
            ListNode[] ret = new ListNode[len/2 + len%2];
            for (int i=0; i<len; i=i+2) {
                if (i < len-1) {
                    ret[i/2] = mergeTwoLists(lists[i], lists[i+1]);
                } else {
                    ret[i/2] = lists[i];
                }
            }
            return mergeKLists1(ret);
        }
    }

    /**
     * 二分递归
     * 时间复杂度：O(log2(n) * sum(len(lists[i])))
     * 空间复杂度：O(1)
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        if (len == 1) return lists[0];

        return mergeKLists(lists, 0, len-1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];

        int mid = (left + right) / 2;

        ListNode leftNode = mergeKLists(lists, left, mid);
        ListNode rightNode = mergeKLists(lists, mid+1, right);

        return mergeTwoLists(leftNode, rightNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode ret = null;
        ListNode temp = null;
        if (l1.val > l2.val) {
            ret = l2;
            l2 = l2.next;
        } else {
            ret = l1;
            l1 = l1.next;
        }
        temp = ret;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }
        }

        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;

        return ret;
    }

}
