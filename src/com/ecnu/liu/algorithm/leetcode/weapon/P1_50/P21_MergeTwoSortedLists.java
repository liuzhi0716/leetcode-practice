package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

import com.ecnu.liu.algorithm.struct.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P21_MergeTwoSortedLists {

    /**
     * 迭代
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
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
